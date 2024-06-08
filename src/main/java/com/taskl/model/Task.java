package com.taskl.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Task {

    private Long id;
    private static Long counter = 0L;
    private String taskName;
    private LocalDateTime startTask;
    private LocalDateTime stopTask;
    private Duration totalTime;

    public Task( String taskName) {

        this.taskName = taskName;
        this.startTask = LocalDateTime.now();
        counter++;
        id = counter;
        totalTime = Duration.ZERO;
    }

    public Task() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static void setCounter(Long counter) {
        Task.counter = counter;
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

    public static Long getCounter() {
        return counter;
    }

    public static Long getId() {
        return counter;
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
//    public void stop() {
//        if (this.startTask != null) {
//            this.stopTask = LocalDateTime.now();
//            this.totalTime = this.totalTime.plus(Duration.between(this.startTask, this.stopTask));
//            this.startTask = null;
//        }
//    }


}
