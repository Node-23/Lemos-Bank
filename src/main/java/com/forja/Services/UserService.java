package com.forja.Services;

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

    protected static User RegisterUser(String name, String email, String password, String address, String phoneNumber, String cpf, Class<?> typeOfUser){
        User user = null;
        if(typeOfUser == CommonUser.class){
            user = new CommonUser(idCount,name, email, password, LocalDateTime.now(), UserStatusEnum.ACTIVE, address, phoneNumber, null, cpf);
        }else if(typeOfUser == Enterprise.class){
            user = new Enterprise();
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

    public static CommonUser CreateCommonUser(){
        UIService.resetInput();
        UIService.HeaderOutPut("REGISTER USER");
        UIService.lineOutput("Your name:");
        String name = UIService.getUserInput();
        UIService.lineOutput("Your email:");
        String email = UIService.getUserInput();
        UIService.lineOutput("Your address:");
        String address = UIService.getUserInput();
        UIService.lineOutput("Your phoneNumber:");
        String phoneNumber = UIService.getUserInput();
        UIService.lineOutput("Your cpf:");
        String cpf = UIService.getUserInput();
        UIService.lineOutput("Your password:");
        String password = UIService.getUserInput();
        UIService.FooterOutput();
        return (CommonUser) UserService.RegisterUser(name, email, password, address, phoneNumber, cpf, CommonUser.class);
    }

    public static Enterprise CreateEnterpriseUser() {
        return new Enterprise();
    }
}
