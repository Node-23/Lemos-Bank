package com.forja.Exceptions;

public class UserException extends Exception{
    public static final String userNotFoundMessage = "User not found";
    public static final String invalidLoginMessage = "Invalid email or password";
    public UserException(String message) {
        super(message);
    }
}
