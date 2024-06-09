package com.task.model;


import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private List<Task> tasks = new ArrayList<>();

    public Project() {
    }

    public Project( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);

    }

    @Override
    public String toString() {
        return "Project: "
                + ", name = " + name;
    }
}

