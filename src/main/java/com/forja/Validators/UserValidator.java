package com.forja.Validators;

import com.forja.Exceptions.InvalidCNPJException;
import com.forja.Exceptions.InvalidCPFException;
import com.forja.Exceptions.InvalidEmailException;
import com.forja.Exceptions.InvalidPasswordException;
import com.forja.Models.CommonUser;
import com.forja.Models.Enterprise;
import com.forja.Models.User;

public class UserValidator {

    public static void ValidateUser(User user) throws InvalidEmailException, InvalidPasswordException, InvalidCNPJException, InvalidCPFException {
        ValidateEmail(user.getEmail());
        ValidatePassword(user.getPassword());
        ValidateDocument(user.getDocument(), user.getClass());
    }

    private static void ValidateEmail(String email) throws InvalidEmailException {
        if(!email.contains("@")){
            throw new InvalidEmailException("Invalid Email");
        }
    }

    private static void ValidatePassword(String password) throws InvalidPasswordException {
        if(password.isEmpty()){
            throw new InvalidPasswordException("Invalid Password");
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
