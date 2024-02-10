package com.forja.Services;

import com.forja.DAO.UsersDAO;
import com.forja.Exceptions.UserException;
import com.forja.Models.CommonUser;
import com.forja.Models.Enterprise;
import com.forja.Models.Enums.UserStatusEnum;
import com.forja.Models.User;
import com.forja.Validators.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;


public class UserService {
    private static long idCount = 1;
    private static final Logger logger = LogManager.getLogger(UserService.class);

    protected static User RegisterUser(String name, String email, String password, String address, String phoneNumber, String document, Class<?> typeOfUser){
        User user;
        if(typeOfUser == CommonUser.class){
            user = new CommonUser(idCount,name, email, password, LocalDateTime.now(), UserStatusEnum.ACTIVE, address, phoneNumber, null, document);
        }else{
            user = new Enterprise(idCount,name, email, password, LocalDateTime.now(), UserStatusEnum.ACTIVE, address, phoneNumber, null, document);
        }
        idCount++;
        try {
            UserValidator.ValidateUser(user);
            return user;
        }catch (Exception e){
            //TODO: Log
            logger.error(e);
            UIService.errorOutput(e.getMessage());
            return null;
        }
    }

    protected static User doLogin(String email, String password){
        try {
            User user = UsersDAO.findUserByEmail(email).orElseThrow(() -> new UserException(UserException.invalidLoginMessage));
            if(!user.getPassword().equals(password)){
                throw new UserException(UserException.invalidLoginMessage);
            }
            return user;
        } catch (UserException e) {
            logger.error(e);
            UIService.errorOutput(e.getMessage());
            return null;
        }
    }
}
