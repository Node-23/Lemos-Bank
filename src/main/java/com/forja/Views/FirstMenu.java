package com.forja.Views;

import com.forja.Models.CommonUser;
import com.forja.Models.Enterprise;
import com.forja.Services.UIService;
import com.forja.Services.UserService;

public class FirstMenu {
    public static void doOption(int option){
        switch (option){
            case 1:
                //TODO: Login
                break;
            case 2:
                UIService.HeaderOutPut("TYPE OF USER");
                UIService.lineOutput("1- Enterprise");
                UIService.lineOutput("2- Common");
                UIService.FooterOutput();
                int typeOfUser = UIService.getUserOption();
                Class<?> type = getTypeOfUser(typeOfUser);
                if(type == CommonUser.class){
                    CommonUser newUser = UserService.CreateCommonUser();
                }else if(type == Enterprise.class){
                    Enterprise newUser = UserService.CreateEnterpriseUser();
                }else{
                    UIService.errorOutput("Invalid option!");
                }
                break;
            case 3:
                UIService.otherOutput("Closing...");
                break;
            default:
                UIService.errorOutput("Invalid option!");
                break;
        }
    }

    private static Class<?> getTypeOfUser(int option){
        return switch (option) {
            case 1 -> Enterprise.class;
            case 2 -> CommonUser.class;
            default -> null;
        };
    }
}
