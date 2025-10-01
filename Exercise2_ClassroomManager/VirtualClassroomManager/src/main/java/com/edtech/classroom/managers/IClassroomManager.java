package com.edtech.classroom.managers;

import com.edtech.classroom.exceptions.ClassroomNotFoundException;
import com.edtech.classroom.exceptions.StudentNotFoundException;
import java.util.List;
import java.util.Set;

public interface IClassroomManager {

    void addClassroom(String name);
    void addStudent(String studentId, String className) throws ClassroomNotFoundException;
    void scheduleAssignment(String className, String assignmentDetails) throws ClassroomNotFoundException;
    void submitAssignment(String studentId, String className, String assignmentDetails) throws ClassroomNotFoundException, StudentNotFoundException;

    List<String> listClassrooms();
    void removeClassroom(String name) throws ClassroomNotFoundException;
    List<String> listStudents(String className) throws ClassroomNotFoundException;
    List<String> listAssignments(String className) throws ClassroomNotFoundException;
    Set<String> getAssignmentSubmissions(String className, String assignmentDetails) throws ClassroomNotFoundException;
}