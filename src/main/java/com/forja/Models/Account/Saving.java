package com.forja.Models.Account;

import com.forja.Exceptions.AccountException;
import com.forja.Models.User.User;
import com.forja.Services.UIService;
import com.forja.Validators.AccountValidator;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class Saving extends Account {
    private LocalDateTime lastCheck;
    private int withdrawsThisMonth;
    private final int WITHDRAWS_LIMIT = 3;
    private static final Logger logger = LogManager.getLogger(Saving.class);

    public Saving(Long id, User user) {
        super(id, user);
        this.lastCheck = LocalDateTime.now();
        this.withdrawsThisMonth = 0;
    }

    public boolean withdraw(BigDecimal value) {
        try {
            canWithdraw();
            AccountValidator.canChangeBalance(value, this);
        } catch (Exception e) {
            logger.error(e);
            UIService.errorOutput(e.getMessage());
            return false;
        }
        this.setBalance(this.getBalance().subtract(value));
        return true;
    }

    private int checkWithdraws(){
        this.setWithdrawsThisMonth(ChronoUnit.MONTHS.between(lastCheck, LocalDateTime.now()) >= 1? 0 : this.getWithdrawsThisMonth());
       return this.getWithdrawsThisMonth();
    }

    private void canWithdraw() throws AccountException {
        if(checkWithdraws() >= WITHDRAWS_LIMIT){
            throw new AccountException("withdrawals limit exceeded");
        }
    }
}
