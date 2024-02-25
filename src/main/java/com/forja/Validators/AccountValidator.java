package com.forja.Validators;

import com.forja.Exceptions.AccountException;
import com.forja.Models.Account.Account;

import java.math.BigDecimal;

public class AccountValidator {

    public static void canChangeBalance(BigDecimal value, Account account) throws AccountException {
        BigDecimal newBalance = account.getBalance().subtract(value);
        validateValue(value);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new AccountException(AccountException.insufficientBalance);
        }
    }

    public static void validateValue(BigDecimal value) throws AccountException {
        if(value.compareTo(BigDecimal.ZERO) < 0){
            throw new AccountException(AccountException.invalidValue);
        }
    }
}
