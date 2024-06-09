package com.task.functions;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContinueTaskTest {

    @Test
    void continueTask() throws IOException, InvalidFormatException {
        ContinueTask.continueTask();
    }
}