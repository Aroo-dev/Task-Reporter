package com.taskl.report;

import com.taskl.model.Project;
import com.taskl.model.Task;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Report {

    public static void printReportALL(List<Project> projectList) {
        System.out.println("---------------------Report for all projects---------------------");
        for (Project project : projectList) {
            projectTotalDuration(project);
            taskTotalDuration(project);
        }
    }

    public static void printReportProject(List<Project> projectList, String projectName) {
        Boolean isPresent;

        isPresent = projectList
                .stream()
                .anyMatch(project -> project.getName().equals(projectName));

        if (!isPresent) {
            System.out.println("Error. " + projectName + " doesn't exist");
        } else {
            System.out.println("-------------Report for \"" + projectName + "\" project-------------");
            Project project = projectList
                    .stream()
                    .filter(entry -> entry.getName().equals(projectName))
                    .findFirst()
                    .get();

            projectTotalDuration(project);
            taskTotalDuration(project);
        }
    }

    public static void projectTotalDuration(Project project) {
        Duration projectTotalDuration = project
                .getTasks()
                .stream()
                .map(entry -> entry.getTotalTime())
                .reduce(Duration.ZERO, (a,b) -> a.plus(b));

        System.out.println("Project \""
                + project.getName()
                + "\" total time duration - "
                + DurationFormatter(projectTotalDuration));
    }

    public static void taskTotalDuration(Project project) {
        TreeMap<String, Duration> taskTotalDuration = new TreeMap<>();

        for (Task task : project.getTasks()) {
            if (!taskTotalDuration.containsKey(task.getTaskName())) {
                taskTotalDuration.put(task.getTaskName(), task.getTotalTime());
            } else {
                Duration duration = taskTotalDuration.get(task.getTaskName()).plus(task.getTotalTime());
                taskTotalDuration.put(task.getTaskName(), duration);
            }
        }
        taskTotalDuration
                .forEach((k,v) -> System.out.println("Task \"" + k + "\" total time duration - " + DurationFormatter(v)));
    }

    private static String DurationFormatter(Duration duration) {
        long seconds = duration.getSeconds();
        long HH = seconds / 3600;
        long MM = (seconds % 3600) / 60;
        long SS = seconds % 60;

        return HH + "h:" + MM + "m:" + SS + "s";
    }
}
