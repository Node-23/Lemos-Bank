package com.forja.Exceptions;

public class AccountException extends Exception{
    public static final String insufficientBalance = "Insufficient balance";
    public static final String invalidValue = "Invalid value";
    public AccountException(String message) {
        super(message);
    }
}
