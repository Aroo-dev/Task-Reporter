package com.task.report;

import com.task.model.Project;
import com.task.model.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class ReportTest {

    private static List<Project> projectList = new ArrayList<>();
    @BeforeAll
    static void setUp(){
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