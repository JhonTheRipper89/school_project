package com.schoolproject.school.docs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectDoc{
    Integer subjectId;
    String name;
}
