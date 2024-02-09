package com.forja.Services;

import com.forja.Exceptions.*;
import com.forja.Models.CommonUser;
import com.forja.Models.Enums.UserStatusEnum;
import com.forja.Validators.UserValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommonUserTest {
    @Test
    public void testCreateCommonUserSuccessfully() {
        CommonUser expected = (CommonUser)UserService.RegisterUser(
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                "Rua das Oliveiras, 120",
                "86999586325",
                "25695874852",
                CommonUser.class
        );

        CommonUser actual = new CommonUser(
                1L,
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852"
        );

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
    public void testInvalidEmailCommonUser() {
        CommonUser newCommonUser = new CommonUser(
                1L,
                "Chico da Silva",
                "chicosemail.com",
                "Test@123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852"
        );
        assertThrows(InvalidEmailException.class, () -> UserValidator.ValidateUser(newCommonUser));
    }
    @Test
    public void testInvalidAddressCommonUser() {
        CommonUser newCommonUser = new CommonUser(
                1L,
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "",
                "86999586325",
                null,
                "25695874852"
        );
        assertThrows(InvalidAddressException.class, () -> UserValidator.ValidateUser(newCommonUser));
    }
    @Test
    public void testInvalidPhoneNumberCommonUser() {
        CommonUser newCommonUser = new CommonUser(
                1L,
                "Chico da Silva",
                "chicos@email.com",
                "asd",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "999586325",
                null,
                "25695874852"
        );
        assertThrows(InvalidPhoneException.class, () -> UserValidator.ValidateUser(newCommonUser));
    }
    @Test
    public void testInvalidCPFCommonUser() {
        CommonUser newCommonUser = new CommonUser(
                1L,
                "Chico da Silva",
                "chicos@email.com",
                "Test@123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "2564852"
        );
        assertThrows(InvalidCPFException.class, () -> UserValidator.ValidateUser(newCommonUser));
    }
    @Test
    public void testPasswordShorterThanSixCharactersCommonUser() {
        CommonUser newCommonUser = new CommonUser(
                1L,
                "Chico da Silva",
                "chicos@email.com",
                "asd",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852"
        );
        InvalidPasswordException exception = assertThrows(InvalidPasswordException.class, () -> UserValidator.ValidateUser(newCommonUser));
        assertEquals(InvalidPasswordException.shorterPasswordExceptionMessage, exception.getMessage());
    }
    @Test
    public void testPasswordWithoutSpecialCharacterCommonUser() {
        CommonUser newCommonUser = new CommonUser(
                1L,
                "Chico da Silva",
                "chicos@email.com",
                "Testa123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852"
        );
        InvalidPasswordException exception = assertThrows(InvalidPasswordException.class, () -> UserValidator.ValidateUser(newCommonUser));
        assertEquals(InvalidPasswordException.specialCharacterPasswordExceptionMessage, exception.getMessage());
    }
    @Test
    public void testPasswordWithoutUpperCaseCharacterCommonUser() {
        CommonUser newCommonUser = new CommonUser(
                1L,
                "Chico da Silva",
                "chicos@email.com",
                "test@123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852"
        );
        InvalidPasswordException exception = assertThrows(InvalidPasswordException.class, () -> UserValidator.ValidateUser(newCommonUser));
        assertEquals(InvalidPasswordException.upperCaseCharacterPasswordExceptionMessage, exception.getMessage());
    }
    @Test
    public void testPasswordWithoutLowerCaseCharacterCommonUser() {
        CommonUser newCommonUser = new CommonUser(
                1L,
                "Chico da Silva",
                "chicos@email.com",
                "TESTA@123",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852"
        );
        InvalidPasswordException exception = assertThrows(InvalidPasswordException.class, () -> UserValidator.ValidateUser(newCommonUser));
        assertEquals(InvalidPasswordException.lowerCaseCharacterPasswordExceptionMessage, exception.getMessage());
    }
    @Test
    public void testPasswordWithoutNumericCharacterCommonUser() {
        CommonUser newCommonUser = new CommonUser(
                1L,
                "Chico da Silva",
                "chicos@email.com",
                "Test@aaa",
                LocalDateTime.now(),
                UserStatusEnum.ACTIVE,
                "Rua das Oliveiras, 120",
                "86999586325",
                null,
                "25695874852"
        );
        InvalidPasswordException exception = assertThrows(InvalidPasswordException.class, () -> UserValidator.ValidateUser(newCommonUser));
        assertEquals(InvalidPasswordException.numericCharacterPasswordExceptionMessage, exception.getMessage());
    }
}