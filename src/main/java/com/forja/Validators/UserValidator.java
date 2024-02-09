package com.forja.Validators;

import com.forja.Exceptions.*;
import com.forja.Models.CommonUser;
import com.forja.Models.Enterprise;
import com.forja.Models.User;

public class UserValidator {
    private static final String specialCharacters = ".*[^a-zA-Z0-9\\s].*";
    private static final String upperCase = ".*[A-Z].*";
    private static final String lowerCase = ".*[a-z].*";

    public static void ValidateUser(User user) throws InvalidEmailException, InvalidPasswordException, InvalidCNPJException, InvalidCPFException, InvalidPhoneException, InvalidAddressException {
        ValidateEmail(user.getEmail());
        ValidatePhone(user.getPhoneNumber());
        ValidatePassword(user.getPassword());
        ValidateAddress(user.getAddress());
        ValidateDocument(user.getDocument(), user.getClass());
    }

    private static void ValidateEmail(String email) throws InvalidEmailException {
        if(!email.contains("@")){
            throw new InvalidEmailException("Invalid Email");
        }
    }

    private static void ValidatePhone(String phoneNumber) throws InvalidPhoneException {
        if(phoneNumber.length() != 11){
            throw new InvalidPhoneException();
        }
    }

    private static void ValidatePassword(String password) throws InvalidPasswordException {
        if(password.length() < 6 || password.matches(specialCharacters) || password.matches(upperCase) || password.matches(lowerCase)){
            throw new InvalidPasswordException("Invalid Password");
        }
    }
    private static void ValidateAddress(String address) throws  InvalidAddressException{
        if(address.isEmpty()){
            throw new InvalidAddressException("Invalid Password");
        }
    }

    private static void ValidateDocument(String document, Class<?> typeOfUser) throws InvalidCPFException, InvalidCNPJException {
        if(typeOfUser == CommonUser.class){
            isValidCPF(document);
        }else if(typeOfUser == Enterprise.class){
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
