package com.edtech.classroom.managers;

import com.edtech.classroom.exceptions.ClassroomNotFoundException;
import com.edtech.classroom.exceptions.StudentNotFoundException;
import com.edtech.classroom.factory.IEntityFactory;
import com.edtech.classroom.models.Assignment;
import com.edtech.classroom.models.Classroom;
import com.edtech.classroom.models.Student;
import com.edtech.classroom.services.ILogger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class VirtualClassroomManager implements IClassroomManager {
    private final Map<String, Classroom> classrooms;
    private final Map<String, Student> students;
    private final ILogger logger;
    private final IEntityFactory factory;

    public VirtualClassroomManager(ILogger logger, IEntityFactory factory) {
        this.classrooms = new HashMap<>();
        this.students = new HashMap<>();
        this.logger = Objects.requireNonNull(logger);
        this.factory = Objects.requireNonNull(factory);
    }

    // --- EXISTING METHODS (UNCHANGED) ---
    @Override
    public void addClassroom(String name) {
        if (classrooms.containsKey(name.toLowerCase())) {
            logger.error("Classroom '" + name + "' already exists.");
            return;
        }
        Classroom newClassroom = factory.createClassroom(name);
        classrooms.put(name.toLowerCase(), newClassroom);
        System.out.println("Classroom " + name + " has been created.");
        logger.info("Classroom '" + name + "' created successfully.");
    }

    @Override
    public void addStudent(String studentId, String className) throws ClassroomNotFoundException {
        Classroom classroom = getClassroom(className);
        Student student = students.computeIfAbsent(studentId, factory::createStudent);
        if (classroom.hasStudent(studentId)) {
            logger.error("Student '" + studentId + "' is already enrolled in '" + className + "'.");
            return;
        }
        classroom.addStudent(student);
        System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        logger.info("Student '" + studentId + "' enrolled in '" + className + "'.");
    }

    @Override
    public void scheduleAssignment(String className, String assignmentDetails) throws ClassroomNotFoundException {
        Classroom classroom = getClassroom(className);
        Assignment newAssignment = factory.createAssignment(assignmentDetails);
        classroom.scheduleAssignment(newAssignment);
        System.out.println("Assignment for " + className + " has been scheduled.");
        logger.info("Assignment '" + assignmentDetails + "' scheduled for '" + className + "'.");
    }

    @Override
    public void submitAssignment(String studentId, String className, String assignmentDetails) throws ClassroomNotFoundException, StudentNotFoundException {
        Classroom classroom = getClassroom(className);
        if (!classroom.hasStudent(studentId)) {
            throw new StudentNotFoundException("Student '" + studentId + "' is not enrolled in '" + className + "'.");
        }
        Student student = students.get(studentId);
        Optional<Assignment> assignmentOpt = classroom.findAssignment(assignmentDetails);
        if (assignmentOpt.isEmpty()) {
            logger.error("Assignment '" + assignmentDetails + "' not found for classroom '" + className + "'.");
            return;
        }
        Assignment assignment = assignmentOpt.get();
        assignment.markAsSubmittedBy(student);
        System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
        logger.info("Student '" + studentId + "' submitted assignment '" + assignmentDetails + "' for '" + className + "'.");
    }

    // --- NEWLY IMPLEMENTED METHODS ---
    @Override
    public List<String> listClassrooms() {
        return classrooms.values().stream()
                .map(Classroom::getName)
                .collect(Collectors.toList());
    }

    @Override
    public void removeClassroom(String name) throws ClassroomNotFoundException {
        if (!classrooms.containsKey(name.toLowerCase())) {
            throw new ClassroomNotFoundException("Classroom '" + name + "' not found.");
        }
        classrooms.remove(name.toLowerCase());
        System.out.println("Classroom " + name + " has been removed.");
        logger.info("Classroom '" + name + "' removed successfully.");
    }

    @Override
    public List<String> listStudents(String className) throws ClassroomNotFoundException {
        Classroom classroom = getClassroom(className);
        return classroom.getStudents().stream()
                .map(Student::getId)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> listAssignments(String className) throws ClassroomNotFoundException {
        Classroom classroom = getClassroom(className);
        return classroom.getAssignments().stream()
                .map(Assignment::getDetails)
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getAssignmentSubmissions(String className, String assignmentDetails) throws ClassroomNotFoundException {
        Classroom classroom = getClassroom(className);
        Optional<Assignment> assignmentOpt = classroom.findAssignment(assignmentDetails);
        if (assignmentOpt.isEmpty()) {
            logger.error("Assignment '" + assignmentDetails + "' not found for classroom '" + className + "'.");
            return Set.of(); // Return an empty set
        }
        return assignmentOpt.get().getSubmissions();
    }

    // --- PRIVATE HELPER METHOD (UNCHANGED) ---
    private Classroom getClassroom(String name) throws ClassroomNotFoundException {
        Classroom classroom = classrooms.get(name.toLowerCase());
        if (classroom == null) {
            throw new ClassroomNotFoundException("Classroom '" + name + "' not found.");
        }
        return classroom;
    }
}