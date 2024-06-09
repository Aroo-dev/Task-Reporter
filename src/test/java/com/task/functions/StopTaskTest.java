package com.task.functions;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class StopTaskTest {

    @Test
    void stopTask() throws IOException, InvalidFormatException {
        StopTask.stop();
    }
}