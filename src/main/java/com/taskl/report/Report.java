package com.taskl.report;

import com.taskl.model.Project;
import com.taskl.model.Task;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Report {


    public static void printReportALL(List<Project> projectList) {
        System.out.println("---------Report for all projects---------");
        for (Project project : projectList) {
            System.out.println(project);
            for (Task task : project.getTasks()) {
                System.out.println(task);
            }
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
            System.out.println("---------Report for " + projectName + " project---------");
            Project project = projectList
                    .stream()
                    .filter(entry -> entry.getName().equals(projectName))
                    .findFirst()
                    .get();

            System.out.println(project);
            project.getTasks().forEach(System.out::println);
        }
    }
}
