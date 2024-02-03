package com.forja.Exceptions;

public class InvalidCNPJException extends Exception{
    public InvalidCNPJException(String message) {
        super(message);
    }

    // Constructor with a default error message
    public InvalidCNPJException() {
        super("Invalid CNPJ");
    }
}
