package com.forja.Models.User;

import com.forja.Models.Account.Account;
import com.forja.Models.Enums.UserStatusEnum;

import java.time.LocalDateTime;

public class Enterprise extends User{
    private String cnpj;

    public Enterprise(Long id, String name, String email, String password, LocalDateTime createAt, UserStatusEnum status, String address, String phoneNumber, Account account, String cnpj) {
        super(id, name, email, address, password, account, phoneNumber, createAt, status);
        this.cnpj = cnpj;
    }

    @Override
    public String getDocument() {
        return cnpj;
    }

    @Override
    public void setDocument(String document) {
        this.cnpj = document;
    }
}
