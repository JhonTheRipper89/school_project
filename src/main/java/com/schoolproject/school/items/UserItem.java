package com.schoolproject.school.items;

import lombok.Data;

@Data
public class UserItem {
    private String name;
    private String lastName;
    private String emailAddress;
    private Long roleId;

}
