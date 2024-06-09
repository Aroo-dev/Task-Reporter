package com.task.functions;

import com.task.db.DataBase;
import com.task.model.Project;
import com.task.model.Task;

import java.util.Optional;

public class StopTask {
    DataBase dataBase = new DataBase();

    private Project getProject(String projectName) {
        return dataBase.getProjectByName(projectName).orElse(null);
    }



    public void stopTask(Long taskId) {
        //Optional<Project> project = dataBase.getAllProjects().stream()
        //        .filter(p -> p.getTasks().stream().anyMatch(t -> t.getId().equals(taskId)))
         //       .findFirst();

       // if (project.isPresent()) {
            //Task task = project.get().getTasks().stream()
            //        .filter(t -> t.getId().equals(taskId))
            //        .findFirst()
            //        .orElse(null);

            //if (task != null) {
            //    task.stop();
             //   System.out.println("Task " + task.getTaskName() + " stopped.");
         //   } else {
          //      System.out.println("Task not found.");
          //  }
        //} else {
         //   System.out.println("Task not found in any project.");
        }
    }


