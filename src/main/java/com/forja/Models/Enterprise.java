package com.forja.Models;

import com.forja.Models.Enums.UserStatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
public class Enterprise extends User{
    private String cnpj;

    public Enterprise(Long id, String name, String email, String password, LocalDateTime createAt, UserStatusEnum status, String address, String phoneNumber, Account account, String cnpj) {
        super(id, name, email, phoneNumber, address, account, password, createAt, status);
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
