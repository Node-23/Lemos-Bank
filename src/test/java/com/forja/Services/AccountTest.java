package com.forja.Services;

import com.forja.Exceptions.AccountException;
import com.forja.Exceptions.UserException;
import com.forja.Models.Account.Checking;
import com.forja.Models.User.CommonUser;
import com.forja.Models.Enums.AccountStatusEnum;
import com.forja.Models.Account.Saving;
import com.forja.Validators.AccountValidator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    @Test
    public void testCreateSimpleSavingAccount(){
        CommonUser expected = (CommonUser)UserService.RegisterUser(
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                "Rua das Oliveiras, 120",
                "86999586325",
                "25695874852",
                CommonUser.class,
                Saving.class
        );

        assertEquals(expected.getAccount().getStatus(), AccountStatusEnum.ACTIVE);
        assertEquals(expected.getAccount().getUser(), expected);
        assertEquals(expected.getAccount().getBalance(), BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testCreateSimpleCheckingAccount(){
        CommonUser expected = (CommonUser)UserService.RegisterUser(
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                "Rua das Oliveiras, 120",
                "86999586325",
                "25695874852",
                CommonUser.class,
                Checking.class
        );

        assertEquals(expected.getAccount().getStatus(), AccountStatusEnum.ACTIVE);
        assertEquals(expected.getAccount().getUser(), expected);
        assertEquals(expected.getAccount().getBalance(), BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testCheckingDepositSuccessfully(){
        CommonUser expected = (CommonUser)UserService.RegisterUser(
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                "Rua das Oliveiras, 120",
                "86999586325",
                "25695874852",
                CommonUser.class,
                Checking.class
        );

        expected.getAccount().deposit(BigDecimal.TEN);
        assertEquals(expected.getAccount().getBalance(), BigDecimal.TEN.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testSavingDepositSuccessfully(){
        CommonUser expected = (CommonUser)UserService.RegisterUser(
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                "Rua das Oliveiras, 120",
                "86999586325",
                "25695874852",
                CommonUser.class,
                Saving.class
        );

        expected.getAccount().deposit(BigDecimal.TEN);
        assertEquals(expected.getAccount().getBalance(), BigDecimal.TEN.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testSavingDepositInvalidValue(){
        CommonUser expected = (CommonUser)UserService.RegisterUser(
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                "Rua das Oliveiras, 120",
                "86999586325",
                "25695874852",
                CommonUser.class,
                Saving.class
        );

        AccountException exception = assertThrows(AccountException.class, () -> AccountValidator.validateValue(new BigDecimal("-10")));
        assertEquals(AccountException.invalidValue, exception.getMessage());
    }

    @Test
    public void testCheckingWithdrawSuccessfully(){
        CommonUser expected = (CommonUser)UserService.RegisterUser(
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                "Rua das Oliveiras, 120",
                "86999586325",
                "25695874852",
                CommonUser.class,
                Checking.class
        );

        expected.getAccount().deposit(new BigDecimal("15"));
        expected.getAccount().withdraw(new BigDecimal("5"));
        assertEquals(expected.getAccount().getBalance(), BigDecimal.TEN.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testSavingWithdrawSuccessfully(){
        CommonUser expected = (CommonUser)UserService.RegisterUser(
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                "Rua das Oliveiras, 120",
                "86999586325",
                "25695874852",
                CommonUser.class,
                Saving.class
        );

        expected.getAccount().deposit(new BigDecimal("15"));
        expected.getAccount().withdraw(new BigDecimal("5"));
        assertEquals(expected.getAccount().getBalance(), BigDecimal.TEN.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testSavingWithdrawInvalidValue(){
        CommonUser expected = (CommonUser)UserService.RegisterUser(
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                "Rua das Oliveiras, 120",
                "86999586325",
                "25695874852",
                CommonUser.class,
                Saving.class
        );

        expected.getAccount().deposit(new BigDecimal("15"));
        AccountException exception = assertThrows(AccountException.class, () -> AccountValidator.canChangeBalance(BigDecimal.TEN.negate(), expected.getAccount()));
        assertEquals(AccountException.invalidValue, exception.getMessage());
    }

    @Test
    public void testSavingWithdrawWithInsufficientBalance(){
        CommonUser expected = (CommonUser)UserService.RegisterUser(
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                "Rua das Oliveiras, 120",
                "86999586325",
                "25695874852",
                CommonUser.class,
                Saving.class
        );

        expected.getAccount().deposit(new BigDecimal("15"));

        AccountException exception = assertThrows(AccountException.class, () -> AccountValidator.canChangeBalance(new BigDecimal("20"), expected.getAccount()));
        assertEquals(AccountException.insufficientBalance, exception.getMessage());
    }
}
