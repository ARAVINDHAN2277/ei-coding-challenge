package com.edtech.classroom.factory;

import com.edtech.classroom.models.Assignment;
import com.edtech.classroom.models.Classroom;
import com.edtech.classroom.models.Student;

public interface IEntityFactory {
    Classroom createClassroom(String name);
    Student createStudent(String id);
    Assignment createAssignment(String details);
}