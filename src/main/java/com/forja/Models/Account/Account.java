package com.forja.Models.Account;

import com.forja.Exceptions.AccountException;
import com.forja.Models.Enums.AccountStatusEnum;
import com.forja.Models.Transfer;
import com.forja.Models.User.User;
import com.forja.Services.UIService;
import com.forja.Validators.AccountValidator;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private BigDecimal balance;
    private static final Logger logger = LogManager.getLogger(Checking.class);

    public Account(Long id, User user) {
        this.id = id;
        this.user = user;
        this.status = AccountStatusEnum.ACTIVE;
        this.transfers = new ArrayList<>();
        this.balance = BigDecimal.ZERO;
    }

    public BigDecimal getBalance(){
        return this.balance.setScale(2, RoundingMode.HALF_EVEN);
    }

    public boolean deposit(BigDecimal value) {
        try{
            AccountValidator.validateValue(value);
        }catch (AccountException e){
            logger.error(e);
            UIService.errorOutput(e.getMessage());
            return false;
        }
        this.setBalance(this.getBalance().add(value));
        return true;
    }

    public abstract boolean withdraw(BigDecimal value);
}
