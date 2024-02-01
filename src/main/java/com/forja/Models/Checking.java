package com.forja.Models;

import java.math.BigDecimal;

public class Checking extends Account{

    @Override
    public void doWithdraw(BigDecimal value) {
        try {
            withdraw(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
