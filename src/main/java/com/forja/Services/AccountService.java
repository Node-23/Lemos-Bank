package com.forja.Services;

import com.forja.Models.Account;
import com.forja.Models.Checking;
import com.forja.Models.Saving;
import com.forja.Models.User;

public class AccountService {
    private static long idCount = 1;
    public static Account createStartAccount(int typeOfAccount, User user){
        if(typeOfAccount == 1){
            return new Saving(idCount++, user);
        }else{
            return new Checking(idCount++, user);
        }
    }
}
