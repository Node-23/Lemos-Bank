package com.forja.Models;

import com.forja.Models.Enums.AccountStatusEnum;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Account {
    private Long id;
    private User user;
    private AccountStatusEnum status;
    private List<Transfer> transfers;
    private BigDecimal balance;

    protected void withdraw(BigDecimal value) throws Exception {
        BigDecimal newBalance = this.getBalance().subtract(value);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            //TODO: Create a transfer exception
            throw new Exception("Transfer rejected");
        } else {
            this.setBalance(newBalance);
        }
    }

    public abstract void doWithdraw(BigDecimal value);
}
