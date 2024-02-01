package com.forja.Models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enterprise extends User{
    private String address;
    private String phoneNumber;
    private Account account;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String cnpj;

    @Override
    public String getDocument() {
        return cnpj;
    }

    @Override
    public void setDocument(String document) {
        this.cnpj = document;
    }
}
