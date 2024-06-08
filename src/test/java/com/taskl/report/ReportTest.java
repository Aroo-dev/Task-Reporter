package com.taskl.report;

import com.taskl.model.Project;
import com.taskl.model.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

    private static List<Project> projectList = new ArrayList<>();
    @BeforeAll
    static void setUp(){
        Project project1 = new Project("Project1");

        Task task1Project1 = new Task("Project 1 Task 1");
        task1Project1.setStopTask(LocalDateTime.of(2024, Month.JUNE, 10, 17, 10));
        task1Project1.setTotalTime(Duration.between(task1Project1.getStartTask(), task1Project1.getStopTask()));

        Task task2project1 = new Task("Project 1 Task 2");
        task2project1.setStopTask(LocalDateTime.of(2024, Month.JUNE, 10, 18, 10));
        task2project1.setTotalTime(Duration.between(task2project1.getStartTask(), task2project1.getStopTask()));

        Task task3Project1 = new Task("Project 1 Task 3");
        task3Project1.setStopTask(LocalDateTime.of(2024, Month.JUNE, 10, 19, 20));
        task3Project1.setTotalTime(Duration.between(task3Project1.getStartTask(), task3Project1.getStopTask()));

        project1.addTask(task1Project1);
        project1.addTask(task2project1);
        project1.addTask(task3Project1);

        Project project2 = new Project("Project2");

        Task task1Project2 = new Task("Project 2 Task 1");
        task1Project2.setStopTask(LocalDateTime.of(2024, Month.JUNE, 10, 17, 10));
        task1Project2.setTotalTime(Duration.between(task1Project2.getStartTask(), task1Project2.getStopTask()));

        Task task2Project2 = new Task("Project 2 Task 2");
        task2Project2.setStopTask(LocalDateTime.of(2024, Month.JUNE, 10, 14, 10));
        task2Project2.setTotalTime(Duration.between(task2Project2.getStartTask(), task2Project2.getStopTask()));

        project2.addTask(task1Project2);
        project2.addTask(task2Project2);

        projectList.add(project1);
        projectList.add(project2);
    }

    @Test
    void printReportALL() {
        Report.printReportALL(projectList);
    }

    @Test
    void printReportProject1() {
        Report.printReportProject(projectList,"Project1");
    }

    @Test
    void printReportProject2() {
        Report.printReportProject(projectList,"Project2");
    }

    @Test
    void printReportProject3() {
        Report.printReportProject(projectList,"Project3");
    }
}