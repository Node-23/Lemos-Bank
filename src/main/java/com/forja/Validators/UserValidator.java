package com.forja.Validators;

import com.forja.Exceptions.*;
import com.forja.Models.User.CommonUser;
import com.forja.Models.User.User;

import java.util.regex.Pattern;

public class UserValidator {
    private static final String specialCharacters = ".*[" + Pattern.quote("!@#$%^&*()-_=+") + "].*";
    private static final String upperCaseCharacters = ".*[A-Z].*";
    private static final String lowerCaseCharacters = ".*[a-z].*";
    private static final String numbersCharacters = ".*\\d.*";

    public static void ValidateUser(User user) throws InvalidEmailException, InvalidPasswordException, InvalidCNPJException, InvalidCPFException, InvalidPhoneException, InvalidAddressException {
        ValidateEmail(user.getEmail());
        ValidatePhone(user.getPhoneNumber());
        ValidatePassword(user.getPassword());
        ValidateAddress(user.getAddress());
        ValidateDocument(user.getDocument(), user.getClass());
    }

    private static void ValidateEmail(String email) throws InvalidEmailException {
        if(!email.contains("@")){
            throw new InvalidEmailException();
        }
    }

    private static void ValidatePhone(String phoneNumber) throws InvalidPhoneException {
        if(phoneNumber.length() != 11){
            throw new InvalidPhoneException();
        }
    }

    private static void ValidatePassword(String password) throws InvalidPasswordException {
        if (password.length() < 6) {
            throw new InvalidPasswordException(InvalidPasswordException.shorterPasswordExceptionMessage);
        } else if (!password.matches(specialCharacters)) {
            throw new InvalidPasswordException(InvalidPasswordException.specialCharacterPasswordExceptionMessage);
        } else if (!password.matches(upperCaseCharacters)) {
            throw new InvalidPasswordException(InvalidPasswordException.upperCaseCharacterPasswordExceptionMessage);
        } else if (!password.matches(lowerCaseCharacters)) {
            throw new InvalidPasswordException(InvalidPasswordException.lowerCaseCharacterPasswordExceptionMessage);
        } else if (!password.matches(numbersCharacters)) {
            throw new InvalidPasswordException(InvalidPasswordException.numericCharacterPasswordExceptionMessage);
        }
    }
    private static void ValidateAddress(String address) throws  InvalidAddressException{
        if(address.isEmpty()){
            throw new InvalidAddressException();
        }
    }

    private static void ValidateDocument(String document, Class<?> typeOfUser) throws InvalidCPFException, InvalidCNPJException {
        if(typeOfUser == CommonUser.class){
            isValidCPF(document);
        }else{
            isValidCNPJ(document);
        }
    }

    private static void isValidCPF(String cpf) throws InvalidCPFException {
        if(cpf.length() != 11){
            throw new InvalidCPFException("Invalid CPF");
        }
    }
    private static void isValidCNPJ(String cnpj) throws InvalidCNPJException {
        if(cnpj.length() != 14){
            throw new InvalidCNPJException("Invalid CNPJ");
        }
    }
}
