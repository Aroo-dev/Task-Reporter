package com.task.functions;

import com.task.model.Task;
import com.task.reader.Reader;
import com.task.writer.Writer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class StopTask {

    public static void stop() throws IOException, InvalidFormatException {
        File file = new File("file.xlsx");

        Task lastTask = Reader.getLast(file);
        if (lastTask == null){
            System.out.println("There's no task to be closed");;
        }if(lastTask.isClosed()){
            System.out.println("The current task is already stopped");
        }else {
            lastTask.setStopTask(LocalDateTime.now());
            lastTask.setIsClosed(true);
            Duration duration = Duration.between(lastTask.getStartTask(),lastTask.getStopTask());
            lastTask.setTotalTime(duration);
            List<Task> lastTasks = List.of(lastTask);
            Writer.overWriteLastRows(lastTasks,file);

        }
    }

}

