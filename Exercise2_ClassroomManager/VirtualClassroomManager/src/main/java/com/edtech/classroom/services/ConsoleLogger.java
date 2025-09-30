package com.edtech.classroom.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger implements ILogger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void info(String message) {
        System.out.println(LocalDateTime.now().format(formatter) + " [INFO] " + message);
    }

    @Override
    public void error(String message) {
        System.err.println(LocalDateTime.now().format(formatter) + " [ERROR] " + message);
    }
}