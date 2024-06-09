package com.task;

import com.task.functions.AppStart;
import com.task.model.Project;
import com.task.last.LastTasks;
import com.task.model.Task;
import com.task.reader.Reader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


@Command(name = "app", subcommands = {App.Start.class, App.Stop.class, App.List.class, App.Continue.class, App.Last.class,
        App.Current.class, App.Help.class, App.Report.class}, separator = " ")
public class App implements Runnable {

    @Override
    public void run() {
        System.out.println("Command missing. Run command 'h' to check list of available commands. ");
    }

    @Command(name = "start", sortOptions = false, sortSynopsis = false)
    static class Start implements Runnable {
        @Option(names = "-t", required = true)
        private String t;
        @Option(names = "-p", required = true)
        private String p;
        @Override
        public void run() {
            try {
                AppStart.start(p,t);
            } catch (IOException | InvalidFormatException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Command(name = "report")
    static class Report implements Runnable {
        @Option(names = "-all")
        private boolean all;
        @Option(names = "--project")
        private String project="";
        @Option(names = "--master")
        private boolean type;
        @Override
        public void run() {
            java.util.List<Project> projectList = new ArrayList<>();
            if(type) {
                File file = new File("fileTemp.xlsx");
                try {
                    projectList = Reader.getAll(file);
                } catch (IOException | InvalidFormatException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                File file = new File("file.xlsx");
                try {
                    projectList = Reader.getAll(file);
                } catch (IOException | InvalidFormatException e) {
                    throw new RuntimeException(e);
                }
            }


            if(all){
                if(!project.isEmpty()){
                    com.task.report.Report.printReportProject(projectList,project);
                }
                else {
                    com.task.report.Report.printReportALL(projectList);
                }
            }


        }
    }

    @Command(name = "stop")
    static class Stop implements Runnable {

        @Override
        public void run() {
            System.out.println("Odwolanie do stopa");
        }
    }

    @Command(name = "continue")
    static class Continue implements Runnable {

        @Override
        public void run() {
            System.out.println("Odwolanie do continue");
        }
    }

    @Command(name = "list")
    static class List implements Runnable {

        @Override
        public void run() {
            System.out.println("Odwolanie do listy");
        }
    }

    @Command(name = "last")
    static class Last implements Runnable {

        @Override
        public void run() {
            java.util.List<Task> tasksList = new ArrayList<>();
                File file = new File("fileTemp.xlsx");
                try {
                    tasksList = Reader.getAllTasks(file);
                } catch (IOException | InvalidFormatException e) {
                    throw new RuntimeException(e);
                }
                tasksList.forEach(System.out::println);
        }
    }

    @Command(name = "current")
    static class Current implements Runnable {

        @Override
        public void run() {
            System.out.println("Odwolanie do aktulnego zadania");
        }
    }

    @Command(name = "h")
    static class Help implements Runnable {

        @Override
        public void run() {
            System.out.println("Aplication use:\n" +
                    "    command 'start' - syntax: 'start -t=<task_name> -p=<project_name>' - starting of task reporting \n" +
                    "    command stop - syntax: 'stop' - without arguments, stopping current task \n" +
                    "    command 'continue' - syntax 'continue' - without arguments, continuation of last task\n" +
                    "    command 'current' - syntax 'current' - without arguments, showing of current task\n" +
                    "    command 'list'\n" +
                    "    command 'last' - syntax 'last' - without arguments, showing of current task\n" +
                    "    command 'project'\n" +
                    "    command 'report' - syntax 'report -all' - report for all projects\n" +
                    "    command 'report' - syntax 'report -all --project=<project_name>' - report for chosen project\n" +
                    "    command 'h' - displaying help");
        }
    }


    public static void main(String[] args) {
        System.out.println("\nProject hours reporting system MWO2023/2024");
        System.out.println("-----------------------------------------------------\n");
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}



