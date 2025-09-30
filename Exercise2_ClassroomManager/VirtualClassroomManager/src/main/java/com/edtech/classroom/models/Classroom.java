package com.edtech.classroom.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Classroom {
    private final String name;
    private final List<Student> students;
    private final List<Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public boolean hasStudent(String studentId) {
        return students.stream().anyMatch(s -> s.getId().equals(studentId));
    }

    // Add these two methods inside your Classroom class
    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public List<Assignment> getAssignments() {
        return Collections.unmodifiableList(assignments);
    }

    public void scheduleAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public Optional<Assignment> findAssignment(String details) {
        return assignments.stream()
                .filter(a -> a.getDetails().equalsIgnoreCase(details))
                .findFirst();
    }
}