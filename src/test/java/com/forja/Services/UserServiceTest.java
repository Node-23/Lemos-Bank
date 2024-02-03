package com.forja.Services;

import com.forja.Exceptions.InvalidCPFException;
import com.forja.Exceptions.InvalidEmailException;
import com.forja.Exceptions.InvalidPasswordException;
import com.forja.Models.CommonUser;
import com.forja.Models.Enums.UserStatusEnum;
import com.forja.Validators.UserValidator;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
	@Test
	public void testCreateCommonUserSuccessfully() {
		CommonUser expected = (CommonUser)UserService.RegisterUser(
				"Chico da Silva",
				"chicos@email.com",
				"asd",
		"Rua das Oliveiras, 120",
				"99586325",
				"25695874852",
				CommonUser.class
		);

		CommonUser actual = new CommonUser(
				1L,
				"Chico da Silva",
				"chicos@email.com",
				"asd",
				LocalDateTime.now(),
				UserStatusEnum.ACTIVE,
				"Rua das Oliveiras, 120",
				"99586325",
				null,
				"25695874852"
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
	public void testInvalidEmailCommonUser() {
		CommonUser newCommonUSer = new CommonUser(1L, "Chico da Silva", "chicosemail.com", "asd", LocalDateTime.now(), UserStatusEnum.ACTIVE, "Rua das Oliveiras, 120", "99586325", null, "25695874852"
		);
		assertThrows(InvalidEmailException.class, () -> UserValidator.ValidateUser(newCommonUSer));
	}
	@Test
	public void testInvalidPasswordCommonUser() {
		CommonUser newCommonUSer = new CommonUser(1L, "Chico da Silva", "chicos@email.com", "", LocalDateTime.now(), UserStatusEnum.ACTIVE, "Rua das Oliveiras, 120", "99586325", null, "25695874852"
		);
		assertThrows(InvalidPasswordException.class, () -> UserValidator.ValidateUser(newCommonUSer));
	}
	@Test
	public void testInvalidDocumentCommonUser() {
		CommonUser newCommonUSer = new CommonUser(1L, "Chico da Silva", "chicos@email.com", "asd", LocalDateTime.now(), UserStatusEnum.ACTIVE, "Rua das Oliveiras, 120", "99586325", null, "2564852"
		);
		assertThrows(InvalidCPFException.class, () -> UserValidator.ValidateUser(newCommonUSer));
	}
}
