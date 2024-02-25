package com.forja.Services;

import com.forja.Models.Checking;
import com.forja.Models.CommonUser;
import com.forja.Models.Enums.AccountStatusEnum;
import com.forja.Models.Saving;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
