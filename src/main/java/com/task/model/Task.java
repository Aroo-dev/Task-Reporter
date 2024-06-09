package com.task.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        this.stopTask = null;
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
    private String DurationFormatter(Duration duration) {
        long seconds = duration.getSeconds();
        long HH = seconds / 3600;
        long MM = (seconds % 3600) / 60;
        long SS = seconds % 60;

        return HH + ":" + MM + ":" + SS;
    }
    @Override
    public String toString() {
        if(stopTask==null)
        {
            return "Task:"
                    + " Task Name = " + taskName
                    + ", Start time of Task = " + startTask.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
                    + ", Stop time of Task = open"
                    + ", Total time = " + DurationFormatter(totalTime);
        } else {
            return "Task:"
                    + " Task Name = " + taskName
                    + ", Start time of Task = " + startTask.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
                    + ", Stop time of Task = " + stopTask.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
                    + ", Total time = " + DurationFormatter(totalTime);
        }

    }


}
