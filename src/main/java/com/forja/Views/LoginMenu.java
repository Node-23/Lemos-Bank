package com.forja.Views;

import com.forja.DAO.UsersDAO;
import com.forja.Models.CommonUser;
import com.forja.Models.Enterprise;
import com.forja.Models.Saving;
import com.forja.Models.User;
import com.forja.Services.UIService;

public class LoginMenu {
    public static void doOption(int option){
        switch (option){
            case 1:
                User user = UIService.Login();
                if(user == null){
                    break;
                }
                UsersDAO.setLoggedUser(user);
                HomeMenu.doHomeMenu();
                break;
            case 2:
                UIService.HeaderOutPut("TYPE OF USER");
                UIService.lineOutput("1- Enterprise");
                UIService.lineOutput("2- Common");
                UIService.FooterOutput();
                int typeOfUser = UIService.getUserOption();
                Class<?> type = getTypeOfUser(typeOfUser);
                if(type == CommonUser.class){
                    UsersDAO.saveUser(UIService.getUserData(type));
                }else if(type == Enterprise.class){
                    UsersDAO.saveUser(UIService.getUserData(type));
                }else{
                    UIService.errorOutput("Invalid option!");
                }
                break;
            case 3:
                UIService.otherOutput("Closing...");
                break;
            case 9:
                UsersDAO.setLoggedUser(UsersDAO.getUsers().get(0));
                UsersDAO.getLoggedUser().setAccount(new Saving(1L, UsersDAO.getLoggedUser()));
                HomeMenu.doHomeMenu();
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
