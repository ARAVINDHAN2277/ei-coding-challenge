package com.edtech.classroom.factory;

import com.edtech.classroom.models.Assignment;
import com.edtech.classroom.models.Classroom;
import com.edtech.classroom.models.Student;

public class EntityFactory implements IEntityFactory {
    @Override
    public Classroom createClassroom(String name) {
        return new Classroom(name);
    }

    @Override
    public Student createStudent(String id) {
        return new Student(id);
    }

    @Override
    public Assignment createAssignment(String details) {
        return new Assignment(details);
    }
}