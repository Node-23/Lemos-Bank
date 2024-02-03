package com.forja.Exceptions;

public class InvalidPasswordException extends Exception{
    public InvalidPasswordException(String message) {
        super(message);
    }

    // Constructor with a default error message
    public InvalidPasswordException() {
        super("Invalid Password");
    }
}
