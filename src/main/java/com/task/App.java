package com.task;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;


@Command(name = "app", subcommands = {App.Start.class, App.Stop.class, App.List.class, App.Continue.class, App.Last.class,
        App.Current.class, App.Help.class}, separator = " ")
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
            System.out.println("Odwolanie do start");
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
            System.out.println("Uzycie aplikacji\n" +
                    "    Komenda start - skladnia: 'start -t=<nazwa_zadania> -p=<nazwa_projektu>'\n" +
                    "    Komenda stop - skladnia: 'stop' - bez argumentow, zatrzymanie aktualnego zadania \n" +
                    "    Komenda continue - skladnia 'continue' - bez argumentow, kontynuacja ostatniego zadania\n" +
                    "    Komenda current - skladnia 'current' - bez argumentow, wyswietlenie aktualnego zadania\n" +
                    "    Komenda list\n" +
                    "    Komenda project - skladnia 'project' - bez argumentow, lista dostepnych projektow\n" +
                    "    Komenda report\n" +
                    "    Komenda h - wyswietlenie pomocy");
        }
    }


    public static void main(String[] args) {
        System.out.println("\nSystem raportowania godzin projektowych MWO2023/2024");
        System.out.println("-----------------------------------------------------\n");
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}



