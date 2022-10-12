package com.schoolproject.school.docs;

import java.util.Date;

import lombok.*;

@Data
@Builder
public class EvaluationDoc {
    Integer evaluationId;
    Integer student_subject_id;
    String score;
    Date time_stamp;
}