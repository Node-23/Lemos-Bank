package com.forja.Exceptions;

public class InvalidCNPJException extends Exception{
    public InvalidCNPJException(String message) {
        super(message);
    }

    public InvalidCNPJException() {
        super("Invalid CNPJ");
    }
}
