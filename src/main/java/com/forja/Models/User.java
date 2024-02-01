package com.forja.Models;

import com.forja.Models.Enums.UserStatusEnum;
import lombok.*;

import java.time.LocalDateTime;
public abstract class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createAt;
    private UserStatusEnum status;
    public abstract String getDocument();

    public abstract void setDocument(String document);
}
