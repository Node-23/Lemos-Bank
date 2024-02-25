package com.forja.Models;

import com.forja.Models.Enums.AccountStatusEnum;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class Account {
    private Long id;
    private User user;
    private AccountStatusEnum status;
    private List<Transfer> transfers;
    @Setter(AccessLevel.NONE)
    private BigDecimal balance;

    public Account(Long id, User user) {
        this.id = id;
        this.user = user;
        this.status = AccountStatusEnum.ACTIVE;
        this.transfers = new ArrayList<>();
        this.balance = BigDecimal.ZERO;
    }

    protected void withdraw(BigDecimal value) throws Exception {
        BigDecimal newBalance = this.getBalance().subtract(value);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            //TODO: Create a transfer exception
            throw new Exception("Transfer rejected");
        } else {
            this.balance = newBalance;
        }
    }

    public BigDecimal getBalance(){
        return this.balance.setScale(2, RoundingMode.HALF_EVEN);
    }

    public abstract void doWithdraw(BigDecimal value);
}
