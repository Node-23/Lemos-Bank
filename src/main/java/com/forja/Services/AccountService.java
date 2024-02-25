package com.forja.Services;

import com.forja.Models.Account;
import com.forja.Models.Checking;
import com.forja.Models.Saving;
import com.forja.Models.User;

public class AccountService {
    private static long idCount = 1;
    public static Account createStartAccount(Class<?> type, User user){
        if(type == Saving.class){
            return new Saving(idCount++, user);
        }else{
            return new Checking(idCount++, user);
        }
    }
}
