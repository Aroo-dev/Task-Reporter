package com.task.writer;

import com.task.model.Task;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;
import com.task.reader.Reader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WriterTest {

    @Test
    void appendRowsCompleteTask() {
        File file = new File("file.xlsx");
        Task task1 = new Task("Task 1", "Project 1");
        task1.setStopTask(LocalDateTime.of(2024, Month.JUNE, 10, 17, 10));
        Duration duration = Duration.between(task1.getStartTask(), task1.getStopTask());
        task1.setTotalTime(duration);
        task1.setIsClosed(true);
        List<Task> recordsToWrite = List.of(task1);
        try {
            Writer.appendRows(recordsToWrite, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void appendRowsUncompleteTask() {
        File file = new File("file.xlsx");
        Task task1 = new Task("Task 2", "Project 1");
        List<Task> recordsToWrite = List.of(task1);
        try {
            Writer.appendRows(recordsToWrite, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void overWriteLastRows() throws IOException, InvalidFormatException {
        File file = new File("file.xlsx");
        Task lastTask = Reader.getLast(file);
        lastTask.setStopTask(LocalDateTime.of(2024, Month.JUNE, 10, 17, 10));
        Duration duration = Duration.between(lastTask.getStartTask(), lastTask.getStopTask());
        lastTask.setTotalTime(duration);
        lastTask.setIsClosed(true);
        List<Task> recordsToWrite = List.of(lastTask);

        try {
            Writer.overWriteLastRows(recordsToWrite, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}