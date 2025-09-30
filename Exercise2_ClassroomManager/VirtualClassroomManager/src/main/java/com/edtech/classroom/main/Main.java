package com.edtech.classroom.main;

import com.edtech.classroom.factory.EntityFactory;
import com.edtech.classroom.factory.IEntityFactory;
import com.edtech.classroom.managers.IClassroomManager;
import com.edtech.classroom.managers.VirtualClassroomManager;
import com.edtech.classroom.services.ConsoleLogger;
import com.edtech.classroom.services.ILogger;
import com.edtech.classroom.ui.CommandProcessor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Dependency Injection: Create all necessary components
        ILogger logger = new ConsoleLogger();
        IEntityFactory factory = new EntityFactory();
        IClassroomManager manager = new VirtualClassroomManager(logger, factory);
        CommandProcessor commandProcessor = new CommandProcessor(manager);

        // 2. Setup application loop
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Virtual Classroom Manager Initialized.");
        System.out.println("Enter commands, or type 'exit' to quit.");
        System.out.println("------------------------------------");

        // 3. Main application loop
        while (isRunning) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input.trim())) {
                isRunning = false;
                continue;
            }

            try {
                commandProcessor.process(input);
            } catch (Exception e) {
                // Gracefully handle all exceptions and log them
                logger.error(e.getMessage());
            }
        }

        System.out.println("Shutting down Virtual Classroom Manager.");
        scanner.close();
    }
}