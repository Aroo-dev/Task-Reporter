package com.task.functions;

import com.task.model.Project;
import com.task.model.Task;
import com.task.reader.Reader;
import com.task.writer.Writer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class AppStart {


    public static void start(String projectName, String taskName) throws IOException, InvalidFormatException {
        File file = new File("file.xlsx");
        Task task = new Task(taskName, projectName);
        List<Task> x1 = List.of(task);


        if (isFileEmpty(file)) {
            addTaskToFile(x1, file);
            System.out.println("Pracujesz teraz nad projektem " + taskName + " w projekcie " + projectName);

        } else if (!isFileEmpty(file)) {

            Task lastTask = Reader.getLast(file);
            if (lastTask.isClosed()) {

                addTaskToFile(x1, file);
                System.out.println("Pracujesz teraz nad projektem " + taskName + " w projekcie " + projectName);
            } else  {
                lastTask.setIsClosed(true);
                lastTask.setStopTask(LocalDateTime.now());
                Duration duration = Duration.between(lastTask.getStartTask(),lastTask.getStopTask());
                lastTask.setTotalTime(duration);
                List<Task> lastTask1 = List.of(lastTask);
                Writer.overWriteLastRows(lastTask1,file);
                addTaskToFile(x1,file);
            }

        }

    }

    private static boolean isFileEmpty(File file) throws IOException, InvalidFormatException {
        return Reader.getLast(file) == null;
    }


    private static void addTaskToFile(List<Task> tasks, File file) throws IOException {
        Writer.appendRows(tasks, file);
    }
}
