package com.forja.Models;

import java.math.BigDecimal;

public class Checking extends Account{

    public Checking(Long id, User user) {
        super(id, user);
    }

    @Override
    public void doWithdraw(BigDecimal value) {
        try {
            withdraw(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
