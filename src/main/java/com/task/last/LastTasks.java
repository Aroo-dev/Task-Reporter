package com.task.last;

import com.task.model.Project;
import com.task.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;
import java.time.Duration;

public class LastTasks {

    public static void printLastTasks(List<Project> projectList) {
        System.out.println("---------------------List of 5 last tasks---------------------");
        ListIterator i = projectList.listIterator(projectList.size());
        List<Project> newList = new ArrayList<>();
        while (i.previousIndex() != projectList.size() - 4) {
            //Object e = i.previous();
            newList= (List<Project>) i.previous();
        }
        for (Project project : projectList) {
            projectTotalDuration(project);
            taskTotalDuration(project);
        }
    }

    public static void projectTotalDuration(Project project) {
        Duration projectTotalDuration = project
                .getTasks()
                .stream()
                .map(entry -> entry.getTotalTime())
                .reduce(Duration.ZERO, (a,b) -> a.plus(b));

        System.out.println("Project \""
                + project.getName()
                + "\" total time duration - "
                + DurationFormatter(projectTotalDuration));
    }

    public static void taskTotalDuration(Project project) {
        TreeMap<String, Duration> taskTotalDuration = new TreeMap<>();

        for (Task task : project.getTasks()) {
            if (!taskTotalDuration.containsKey(task.getTaskName())) {
                taskTotalDuration.put(task.getTaskName(), task.getTotalTime());
            } else {
                Duration duration = taskTotalDuration.get(task.getTaskName()).plus(task.getTotalTime());
                taskTotalDuration.put(task.getTaskName(), duration);
            }
        }
        taskTotalDuration
                .forEach((k,v) -> System.out.println("Task \"" + k + "\" total time duration - " + DurationFormatter(v)));
    }

    private static String DurationFormatter(Duration duration) {
        long seconds = duration.getSeconds();
        long HH = seconds / 3600;
        long MM = (seconds % 3600) / 60;
        long SS = seconds % 60;

        return HH + "h:" + MM + "m:" + SS + "s";
    }
}
