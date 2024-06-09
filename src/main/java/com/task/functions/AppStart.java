package com.task.functions;

import com.task.db.DataBase;
import com.task.model.Project;
import com.task.model.Task;

public class AppStart {


    DataBase dataBase = new DataBase();


    public Task start(String projectName, String taskName) {
        Project project = getProject(projectName);

        if (project == null) {
//            System.out.println("Project not found, creating new project: " + projectName);
            project = dataBase.importProject(projectName);
        }

        Task task = new Task(taskName);
        project.addTask(task);

        return task;
    }

    private Project getProject(String projectName) {
        return dataBase.getProjectByName(projectName).orElse(null);
    }



}
