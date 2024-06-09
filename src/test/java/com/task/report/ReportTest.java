package com.task.report;

import com.task.model.Project;
import com.task.model.Task;
import com.task.reader.Reader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class ReportTest {

    private static List<Project> projectList = new ArrayList<>();
    @BeforeAll
    static void setUp() throws IOException, InvalidFormatException {
        File file = new File("fileTemp.xlsx");
        projectList = Reader.getAll(file);

    }

    @Test
    void printReportALL() {
        Report.printReportALL(projectList);
    }

    @Test
    void printReportProject1() {
        Report.printReportProject(projectList,"Project 1");
    }

    @Test
    void printReportProject2() {
        Report.printReportProject(projectList,"Project 2");
    }

    @Test
    void printReportProject3() {
        Report.printReportProject(projectList,"Project 3");
    }
}