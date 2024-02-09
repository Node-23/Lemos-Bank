package com.forja.Exceptions;

public class InvalidAddressException extends Exception{
    public InvalidAddressException(String message) {
        super(message);
    }

    public InvalidAddressException() {
        super("Invalid Address");
    }
}
