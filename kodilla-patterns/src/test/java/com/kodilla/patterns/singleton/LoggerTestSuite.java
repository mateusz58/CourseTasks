package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTestSuite {

    @BeforeEach
    void setUp() {
        Logger.getInstance().setLastLog("log");
    }

    @AfterEach
    void finish(){
        Logger.getInstance().resetLogs();
    }

    @Test
    void test() {
        assertEquals("log", Logger.getInstance().getLastLog());
    }

}