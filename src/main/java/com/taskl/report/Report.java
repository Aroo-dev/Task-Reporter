package com.taskl.report;

import com.taskl.model.Project;
import com.taskl.model.Task;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Report {

    public static List<Project> setUp(){
        List<Project> projectList = new ArrayList<>();

        Project project1 = new Project(1L, "Project1");
        Project project2 = new Project(2L, "Project2");

        Task task1Project1 = new Task("Project 1 Task 1");
        task1Project1.setStopTask(LocalDateTime.of(2024, Month.JUNE, 8, 17, 10));
        task1Project1.setTotalTime(Duration.between(task1Project1.getStartTask(), task1Project1.getStopTask()));

        Task task2project1 = new Task("Project 1 Task 2");
        task2project1.setStopTask(LocalDateTime.of(2024, Month.JUNE, 8, 18, 10));
        task2project1.setTotalTime(Duration.between(task2project1.getStartTask(), task2project1.getStopTask()));

        Task task3Project1 = new Task("Project 1 Task 3");
        task3Project1.setStopTask(LocalDateTime.of(2024, Month.JUNE, 8, 19, 20));

        return projectList;
    }

    public static void main(String[] args) {
        List<Project> projectList = setUp();

        projectList.forEach(System.out::println);
    }
}
