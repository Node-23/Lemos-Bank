package com.forja.Services;

import com.forja.Exceptions.*;
import com.forja.Models.Enterprise;
import com.forja.Models.Enums.UserStatusEnum;
import com.forja.Validators.UserValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EnterpriseTest {
    @Test
    public void testCreateEnterpriseSuccessfully() {
        Enterprise expected = (Enterprise)UserService.RegisterUser(
                "Casa das Rosas",
                "casadasrosas@email.com",
                "Test@123",
                "Rua das Oliveiras, 120",
                "86999586325",
                "25695874852234",
                Enterprise.class
        );

        Enterprise actual = new Enterprise(
                1L,
                "Casa das Rosas",
                "casadasrosas@email.com",
                "Test@123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852234"
        );

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.getStatus(), actual.getStatus());
        assertEquals(expected.getAddress(), actual.getAddress());
        assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(expected.getAccount(), actual.getAccount());
        assertEquals(expected.getDocument(), actual.getDocument());
    }

    @Test
    public void testInvalidEmailEnterprise() {
        Enterprise newEnterprise = new Enterprise(
                1L,
                "Casa das Rosas",
                "chicosemail.com",
                "Test@123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852234"
        );
        assertThrows(InvalidEmailException.class, () -> UserValidator.ValidateUser(newEnterprise));
    }
    @Test
    public void testInvalidAddressEnterprise() {
        Enterprise newEnterprise = new Enterprise(
                1L,
                "Casa das Rosas",
                "casadasrosas@email.com",
                "Test@123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "",
                "86999586325",
                null,
                "25695874852234"
        );
        assertThrows(InvalidAddressException.class, () -> UserValidator.ValidateUser(newEnterprise));
    }
    @Test
    public void testInvalidPhoneNumberEnterprise() {
        Enterprise newEnterprise = new Enterprise(
                1L,
                "Casa das Rosas",
                "casadasrosas@email.com",
                "asd",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "999586325",
                null,
                "25695874852234"
        );
        assertThrows(InvalidPhoneException.class, () -> UserValidator.ValidateUser(newEnterprise));
    }
    @Test
    public void testInvalidCNPJEnterprise() {
        Enterprise newEnterprise = new Enterprise(
                1L,
                "Casa das Rosas",
                "casadasrosas@email.com",
                "Test@123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "2564852"
        );
        assertThrows(InvalidCNPJException.class, () -> UserValidator.ValidateUser(newEnterprise));
    }
    @Test
    public void testPasswordShorterThanSixCharactersEnterprise() {
        Enterprise newEnterprise = new Enterprise(
                1L,
                "Casa das Rosas",
                "casadasrosas@email.com",
                "asd",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852234"
        );
        InvalidPasswordException exception = assertThrows(InvalidPasswordException.class, () -> UserValidator.ValidateUser(newEnterprise));
        assertEquals(InvalidPasswordException.shorterPasswordExceptionMessage, exception.getMessage());
    }
    @Test
    public void testPasswordWithoutSpecialCharacterEnterprise() {
        Enterprise newEnterprise = new Enterprise(
                1L,
                "Casa das Rosas",
                "casadasrosas@email.com",
                "Test123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852234"
        );
        InvalidPasswordException exception = assertThrows(InvalidPasswordException.class, () -> UserValidator.ValidateUser(newEnterprise));
        assertEquals(InvalidPasswordException.specialCharacterPasswordExceptionMessage, exception.getMessage());
    }
    @Test
    public void testPasswordWithoutUpperCaseCharacterEnterprise() {
        Enterprise newEnterprise = new Enterprise(
                1L,
                "Casa das Rosas",
                "casadasrosas@email.com",
                "test@123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852234"
        );
        InvalidPasswordException exception = assertThrows(InvalidPasswordException.class, () -> UserValidator.ValidateUser(newEnterprise));
        assertEquals(InvalidPasswordException.upperCaseCharacterPasswordExceptionMessage, exception.getMessage());
    }
    @Test
    public void testPasswordWithoutLowerCaseCharacterEnterprise() {
        Enterprise newEnterprise = new Enterprise(
                1L,
                "Casa das Rosas",
                "casadasrosas@email.com",
                "TEST@123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852234"
        );
        InvalidPasswordException exception = assertThrows(InvalidPasswordException.class, () -> UserValidator.ValidateUser(newEnterprise));
        assertEquals(InvalidPasswordException.lowerCaseCharacterPasswordExceptionMessage, exception.getMessage());
    }
    @Test
    public void testPasswordWithoutNumericCharacterEnterprise() {
        Enterprise newEnterprise = new Enterprise(
                1L,
                "Casa das Rosas",
                "casadasrosas@email.com",
                "Test@aaaa",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852234"
        );
        InvalidPasswordException exception = assertThrows(InvalidPasswordException.class, () -> UserValidator.ValidateUser(newEnterprise));
        assertEquals(InvalidPasswordException.numericCharacterPasswordExceptionMessage, exception.getMessage());
    }
}