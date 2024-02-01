package com.forja.Models;

import com.forja.Models.Enums.AdminRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Long id;
    private AdminRoleEnum role;
    private String name;
    private String email;
    private String password;
}
