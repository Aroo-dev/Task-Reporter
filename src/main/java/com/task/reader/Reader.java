package com.task.reader;

import com.task.model.Project;
import com.task.model.Task;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static Task getLast(File file) throws IOException, InvalidFormatException {
        Task lastTask = new Task();
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();

        int n = sheet.getPhysicalNumberOfRows();

        Row row = sheet.getRow(n-1);
        int i = row.getFirstCellNum();

        String projectName = dataFormatter.formatCellValue(row.getCell(++i));
        String taskName = dataFormatter.formatCellValue(row.getCell(++i));
        Boolean isClose = row.getCell(++i).getBooleanCellValue();
        LocalDateTime startTask = row.getCell(++i).getLocalDateTimeCellValue();
        LocalDateTime stopTask = row.getCell(++i).getLocalDateTimeCellValue();
        Duration totalTime = Duration.parse((CharSequence) dataFormatter.formatCellValue(row.getCell(++i)));

        lastTask.setTaskName(taskName);
        lastTask.setProjectName(projectName);
        lastTask.setIsClosed(isClose);
        lastTask.setStartTask(startTask);
        lastTask.setStopTask(stopTask);
        lastTask.setTotalTime(totalTime);

        return lastTask;
    }

    public static List<Project> getAll(File file) throws IOException, InvalidFormatException {
        List<Project> projectList = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        for (int n = 1; n < sheet.getPhysicalNumberOfRows(); n++) {
            Row row = sheet.getRow(n);
            int i = row.getFirstCellNum();

            String projectName = dataFormatter.formatCellValue(row.getCell(++i));
            String taskName = dataFormatter.formatCellValue(row.getCell(++i));
            Boolean isClose = row.getCell(++i).getBooleanCellValue();
            LocalDateTime startTask = row.getCell(++i).getLocalDateTimeCellValue();
            LocalDateTime stopTask = row.getCell(++i).getLocalDateTimeCellValue();
            Duration totalTime = Duration.parse((CharSequence) dataFormatter.formatCellValue(row.getCell(++i)));

            Task task = new Task();
            task.setTaskName(taskName);
            task.setProjectName(projectName);
            task.setIsClosed(isClose);
            task.setStartTask(startTask);
            task.setStopTask(stopTask);
            task.setTotalTime(totalTime);

            Boolean isPresent;

            isPresent = projectList
                    .stream()
                    .anyMatch(project -> project.getName().equals(projectName));

            if (!isPresent) {
                Project project = new Project(projectName);
                project.addTask(task);
                projectList.add(project);
            } else {
                Project project = projectList
                        .stream()
                        .filter(entry -> entry.getName().equals(projectName))
                        .findFirst()
                        .get();

                project.getTasks().add(task);
            }

        }

        for (Project project : projectList) {
            System.out.println(project);
            for (Task task : project.getTasks())  {
                System.out.println(task);
            }
        }

        return projectList;
    }

}
