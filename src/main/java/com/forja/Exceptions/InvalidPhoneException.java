package com.forja.Exceptions;

public class InvalidPhoneException extends Exception{
    public InvalidPhoneException(String message) {
        super(message);
    }

    public InvalidPhoneException() {
        super("Invalid Phone number");
    }
}
