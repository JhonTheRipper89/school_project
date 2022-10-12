package com.schoolproject.school.dtos;

import java.util.Date;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EvaluationDto {
     Integer evaluationId;
    Integer student_subject_id;
    String score;
    Date time_stamp;
}
