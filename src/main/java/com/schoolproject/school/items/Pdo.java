package com.schoolproject.school.items;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pdo {
    private String name;
    private String lastName;
    private String emailAddress;
    private Long roleId;

}
