package com.task.functions;

import com.task.model.Task;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppStartTest {

    @Test
    void startToEmptyFile() throws IOException, InvalidFormatException {
        AppStart.start("test12","projekt1");

    }
    @Test
    void createNewTaskWhenNotClosed() throws IOException, InvalidFormatException {
        AppStart.start("test2","projekt2");

    }
}