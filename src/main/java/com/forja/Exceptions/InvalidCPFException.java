package com.forja.Exceptions;

public class InvalidCPFException extends Exception{
    public InvalidCPFException(String message) {
        super(message);
    }

    // Constructor with a default error message
    public InvalidCPFException() {
        super("Invalid CPF");
    }
}
