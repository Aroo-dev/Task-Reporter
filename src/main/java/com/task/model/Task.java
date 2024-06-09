package com.task.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Task {
    private String taskName;

    private boolean isClosed;
    private String projectName;
    private LocalDateTime startTask;
    private LocalDateTime stopTask;
    private Duration totalTime;

    public Task( String taskName, String projectName) {

        this.taskName = taskName;
        this.projectName = projectName;
        this.startTask = LocalDateTime.now();
        totalTime = Duration.ZERO;
        this.isClosed = false;
    }

    public Task() {
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setStartTask(LocalDateTime startTask) {
        this.startTask = startTask;
    }

    public void setStopTask(LocalDateTime stopTask) {
        this.stopTask = stopTask;
    }

    public void setTotalTime(Duration totalTime) {
        this.totalTime = totalTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean closed) {
        isClosed = closed;
    }

    public String getTaskName() {
        return taskName;
    }

    public LocalDateTime getStartTask() {
        return startTask;
    }

    public LocalDateTime getStopTask() {
        return stopTask;
    }

    public Duration getTotalTime() {
        return totalTime;
    }
    public void stop() {
        if (this.startTask != null) {
            this.stopTask = LocalDateTime.now();
            this.totalTime = this.totalTime.plus(Duration.between(this.startTask, this.stopTask));
            this.startTask = null;
        }
    }


}
