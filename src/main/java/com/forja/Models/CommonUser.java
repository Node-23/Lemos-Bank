package com.forja.Models;

import com.forja.Models.Enums.UserStatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
public class CommonUser extends User{
    private String cpf;

    public CommonUser(Long id, String name, String email, String password, LocalDateTime createAt, UserStatusEnum status, String address, String phoneNumber, Account account, String cpf) {
        super(id, name, email, phoneNumber, address, account, password, createAt, status);
        this.cpf = cpf;
    }

    @Override
    public String getDocument() {
        return cpf;
    }

    @Override
    public void setDocument(String document) {
        this.cpf = document;
    }
}
