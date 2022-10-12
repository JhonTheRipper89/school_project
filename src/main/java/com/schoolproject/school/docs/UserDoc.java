package com.schoolproject.school.docs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDoc {
    Integer userId;
    String name;
    String lastName;
    String role;
    Integer roleId;
    String emailAddress;
}
