package com.schoolproject.school.docs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentSubjectDoc {
    String subject;
    Integer subjectId;
    Double grade;
}
