package com.edtech.classroom.ui;

import com.edtech.classroom.exceptions.ClassroomNotFoundException;
import com.edtech.classroom.exceptions.InvalidCommandException;
import com.edtech.classroom.exceptions.StudentNotFoundException;
import com.edtech.classroom.managers.IClassroomManager;

public class CommandProcessor {
    private final IClassroomManager manager;

    public CommandProcessor(IClassroomManager manager) {
        this.manager = manager;
    }

    public void process(String input) throws InvalidCommandException, ClassroomNotFoundException, StudentNotFoundException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidCommandException("Input cannot be empty.");
        }

        String[] parts = input.trim().split("\\s+");
        String command = parts[0].toLowerCase();

        switch (command) {

            case "add_classroom":
                if (parts.length != 2) throw new InvalidCommandException("Usage: add_classroom <ClassName>");
                manager.addClassroom(parts[1]);
                break;
            case "add_student":
                if (parts.length != 3) throw new InvalidCommandException("Usage: add_student <StudentId> <ClassName>");
                manager.addStudent(parts[1], parts[2]);
                break;
            case "schedule_assignment":
                String[] scheduleParts = input.trim().split("\\s+", 3);
                if (scheduleParts.length != 3) throw new InvalidCommandException("Usage: schedule_assignment <ClassName> <AssignmentDetails>");
                manager.scheduleAssignment(scheduleParts[1], scheduleParts[2]);
                break;
            case "submit_assignment":
                String[] submitParts = input.trim().split("\\s+", 4);
                if (submitParts.length != 4) throw new InvalidCommandException("Usage: submit_assignment <StudentId> <ClassName> <AssignmentDetails>");
                manager.submitAssignment(submitParts[1], submitParts[2], submitParts[3]);
                break;
            case "list_classrooms":
                if (parts.length != 1) throw new InvalidCommandException("Usage: list_classrooms");
                System.out.println("Available Classrooms: " + manager.listClassrooms());
                break;
            case "remove_classroom":
                if (parts.length != 2) throw new InvalidCommandException("Usage: remove_classroom <ClassName>");
                manager.removeClassroom(parts[1]);
                break;
            case "list_students":
                if (parts.length != 2) throw new InvalidCommandException("Usage: list_students <ClassName>");
                System.out.println("Students in " + parts[1] + ": " + manager.listStudents(parts[1]));
                break;
            case "list_assignments":
                if (parts.length != 2) throw new InvalidCommandException("Usage: list_assignments <ClassName>");
                System.out.println("Assignments for " + parts[1] + ": " + manager.listAssignments(parts[1]));
                break;
            case "assignment_status":
                String[] statusParts = input.trim().split("\\s+", 3);
                if (statusParts.length != 3) throw new InvalidCommandException("Usage: assignment_status <ClassName> <AssignmentDetails>");
                System.out.println("Submissions for '" + statusParts[2] + "': " + manager.getAssignmentSubmissions(statusParts[1], statusParts[2]));
                break;

            default:
                throw new InvalidCommandException("Unknown command: " + command);
        }
    }
}