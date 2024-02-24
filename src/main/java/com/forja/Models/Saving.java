package com.forja.Models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class Saving extends Account{
    private LocalDateTime lastCheck;
    private int withdrawsThisMonth;
    private final int WITHDRAWS_LIMIT = 3;

    public Saving(Long id, User user) {
        super(id, user);
        this.lastCheck = LocalDateTime.now();
        this.withdrawsThisMonth = 0;
    }

    @Override
    public void doWithdraw(BigDecimal value) {
        try {
            if(checkWithdraws() >= WITHDRAWS_LIMIT){
                //TODO: Create a transfer exception
                throw new Exception("withdrawals limit exceeded");
            }
            withdraw(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int checkWithdraws(){
        this.setWithdrawsThisMonth(ChronoUnit.MONTHS.between(lastCheck, LocalDateTime.now()) >= 1? 0 : this.getWithdrawsThisMonth());
       return this.getWithdrawsThisMonth();
    }
}
