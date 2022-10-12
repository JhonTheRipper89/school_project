package com.schoolproject.school.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
     Integer userId;
     String name;
     String lastName;
     String role;
     Integer roleId;
     String emailAddress;
     String password;
}
