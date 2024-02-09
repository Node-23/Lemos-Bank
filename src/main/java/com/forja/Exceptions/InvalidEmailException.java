package com.forja.Exceptions;

public class InvalidEmailException extends Exception{
    public InvalidEmailException(String message) {
        super(message);
    }

    public InvalidEmailException() {
        super("Invalid Email");
    }
}
