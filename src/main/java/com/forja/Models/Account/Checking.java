package com.forja.Models.Account;

import com.forja.Exceptions.AccountException;
import com.forja.Models.User.User;
import com.forja.Services.UIService;
import com.forja.Validators.AccountValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class Checking extends Account {
    private static final Logger logger = LogManager.getLogger(Checking.class);

    public Checking(Long id, User user) {
        super(id, user);
    }

    public boolean withdraw(BigDecimal value) {
        try {
            AccountValidator.canChangeBalance(value, this);
        } catch (AccountException e) {
            logger.error(e);
            UIService.errorOutput(e.getMessage());
            return false;
        }
        this.setBalance(this.getBalance().subtract(value));
        return true;
    }
}
