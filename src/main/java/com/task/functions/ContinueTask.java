package com.task.functions;


import com.task.model.Task;
import com.task.reader.Reader;
import com.task.writer.Writer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ContinueTask {

    public static void continueTask() throws IOException, InvalidFormatException {
        File file = new File("file.xlsx");
        Task last = Reader.getLast(file);
        if (last == null){
            throw new RuntimeException("There's no task to be continued");
        }
        if (!last.isClosed()){
            throw new RuntimeException("Task is already opened - " + last.getTaskName());
        }else {
            Task task = new Task(last.getTaskName(), last.getProjectName());
            List<Task> task1 = List.of(task);
            Writer.appendRows(task1,file);


        }
    }
}
