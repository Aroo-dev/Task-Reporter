package com.task;
import com.task.functions.AppStart;
import com.task.report.*;
import com.task.model.Project;
import com.task.model.Task;
import com.task.report.Report;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


@Command(name = "app", subcommands = {App.Start.class, App.Stop.class, App.List.class, App.Continue.class, App.Last.class,
        App.Current.class, App.Help.class, App.Report.class}, separator = " ")
public class App implements Runnable {

    @Override
    public void run() {
        System.out.println("In Utility");
    }

    @Command(name = "start", sortOptions = false, sortSynopsis = false)
    static class Start implements Runnable {
        @Option(names = "-t", required = true)
        private String t;
        @Option(names = "-p", required = true)
        private String p;
        @Override
        public void run() {
            AppStart start = new AppStart();
            start.start(p, t);
        }
    }
    @Command(name = "report")
    static class Report implements Runnable {
        @Option(names = "-all")
        private boolean all;
        @Option(names = "--project")
        private String project="";
        @Override
        public void run() {
            java.util.List<Project> projectList = new ArrayList<>();
            Project project1 = new Project("Project1");

            Task project1Task1 = new Task("Task 1", "Project 1");
            project1Task1.setTotalTime(Duration.ofMinutes(10));

            Task project1Task2 = new Task("Task 2", "Project 1");
            project1Task2.setTotalTime(Duration.ofMinutes(20));

            Task project1Task3 = new Task("Task 3", "Project 1");
            project1Task3.setTotalTime(Duration.ofMinutes(30));

            Task project1Task4 = new Task("Task 1", "Project 1");
            project1Task4.setTotalTime(Duration.ofMinutes(10));

            Task project1Task5 = new Task("Task 2", "Project 1");
            project1Task5.setTotalTime(Duration.ofMinutes(20));

            Task project1Task6 = new Task("Task 3", "Project 1");
            project1Task6.setTotalTime(Duration.ofMinutes(30));

            project1.addTask(project1Task1);
            project1.addTask(project1Task2);
            project1.addTask(project1Task3);
            project1.addTask(project1Task4);
            project1.addTask(project1Task5);
            project1.addTask(project1Task6);

            Project project2 = new Project("Project2");

            Task project2Task1 = new Task("Task 1", "Project 2");
            project2Task1.setTotalTime(Duration.ofMinutes(120));

            Task project2Task2 = new Task("Task 2", "Project 2");
            project2Task2.setTotalTime(Duration.ofMinutes(30));

            Task project2Task3 = new Task("Task 2", "Project 2");
            project2Task3.setTotalTime(Duration.ofMinutes(30));

            Task project2Task4 = new Task("Task 2", "Project 2");
            project2Task4.setTotalTime(Duration.ofMinutes(30));

            project2.addTask(project2Task1);
            project2.addTask(project2Task2);
            project2.addTask(project2Task3);
            project2.addTask(project2Task4);

            projectList.add(project1);
            projectList.add(project2);

            if(all==true){
                if(!project.isEmpty() & all==true){
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
            System.out.println("Odwolanie do ostatnich 5 zadan");
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



