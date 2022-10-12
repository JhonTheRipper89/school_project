package com.schoolproject.school.docs;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentDoc {
    Integer studentId;
    String name;
    String lastName;
    String role;
    List<StudentSubjectDoc> subjects;
}
