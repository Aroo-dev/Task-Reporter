package com.task.last;

import com.task.model.Project;
import com.task.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;
import java.time.Duration;

public class LastTasks {

    public static void printLastTasks(List<Task> taskList) {
        System.out.println("---------------------List of 5 last tasks---------------------");
        for (Task task : taskList) {
            System.out.println(task);
        }
    }
}
