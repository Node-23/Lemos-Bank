package com.forja.Models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonUser extends User{
    private String address;
    private String phoneNumber;
    private Account account;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String cpf;

    @Override
    public String getDocument() {
        return cpf;
    }

    @Override
    public void setDocument(String document) {
        this.cpf = document;
    }
}
