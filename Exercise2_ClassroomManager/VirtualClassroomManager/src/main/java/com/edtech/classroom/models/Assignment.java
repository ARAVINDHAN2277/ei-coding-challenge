package com.edtech.classroom.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Assignment {
    private final String details;
    private final Set<String> submittedByStudentIds;

    public Assignment(String details) {
        this.details = details;
        this.submittedByStudentIds = new HashSet<>();
    }

    public String getDetails() {
        return details;
    }

    public void markAsSubmittedBy(Student student) {
        this.submittedByStudentIds.add(student.getId());
    }

    public Set<String> getSubmissions() {
        return Collections.unmodifiableSet(submittedByStudentIds);
    }
}