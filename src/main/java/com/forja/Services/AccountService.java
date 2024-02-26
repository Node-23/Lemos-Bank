package com.forja.Services;

import com.forja.Models.Account.Account;
import com.forja.Models.Account.Checking;
import com.forja.Models.Account.Saving;
import com.forja.Models.User.User;

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
