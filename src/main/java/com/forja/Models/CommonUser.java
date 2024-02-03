package com.forja.Models;

import com.forja.Models.Enums.UserStatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommonUser extends User{
    private String address;
    private String phoneNumber;
    private Account account;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String cpf;

    public CommonUser(Long id, String name, String email, String password, LocalDateTime createAt, UserStatusEnum status, String address, String phoneNumber, Account account, String cpf) {
        super(id, name, email, password, createAt, status);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.account = account;
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
