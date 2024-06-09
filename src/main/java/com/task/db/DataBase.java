package com.task.db;

import com.task.model.Project;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataBase {


    private List<Project> projects = new ArrayList<>();

    public DataBase() {
    }

    public DataBase(List<Project> projects) {
        this.projects = projects;
    }

    public Project importProject(String name) {
        Project project = new Project(name);
        projects.add(project);
        return project;
    }

    public List<Project> getAllProjects() {
        return projects;
    }

    public Optional<Project> getProjectById(Long id) {
     //   return projects.stream().filter(p -> p.getId().equals(id)).findFirst();
    return null;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }


    public Optional<Project> getProjectByName(String name) {
        return projects.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "projects=" + projects +
                '}';
    }



}

