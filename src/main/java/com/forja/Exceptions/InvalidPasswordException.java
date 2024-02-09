package com.forja.Exceptions;

public class InvalidPasswordException extends Exception{
    public static final String shorterPasswordExceptionMessage = "Password must have at least 6 digits";
    public static final String specialCharacterPasswordExceptionMessage = "Password must have at least one special character like !, @, #, etc";
    public static final String upperCaseCharacterPasswordExceptionMessage = "Password must have at least one upper case letter";
    public static final String lowerCaseCharacterPasswordExceptionMessage = "Password must have at least one lower case letter";
    public static final String numericCharacterPasswordExceptionMessage = "Password must have at least one number";
    public InvalidPasswordException(String message) {
        super(message);
    }
}
