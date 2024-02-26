package com.forja.Models.User;

import com.forja.Models.Account.Account;
import com.forja.Models.Enums.UserStatusEnum;

import java.time.LocalDateTime;

public class CommonUser extends User{
    private String cpf;

    public CommonUser(Long id, String name, String email, String password, LocalDateTime createAt, UserStatusEnum status, String address, String phoneNumber, Account account, String cpf) {
        super(id, name, email, address, password, account, phoneNumber, createAt, status);
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
