package com.forja.Views;

import com.forja.DAO.UsersDAO;
import com.forja.Models.User.CommonUser;
import com.forja.Models.User.Enterprise;
import com.forja.Models.Account.Saving;
import com.forja.Models.User.User;
import com.forja.Services.UIService;

public class LoginMenu {
    private static void doOption(int option){
        switch (option){
            case 1:
                User user = UIService.Login();
                if(user == null){
                    break;
                }
                UsersDAO.setLoggedUser(user);
                UIService.sucessOutput("Logged In!");
                HomeMenu.doHomeMenu();
                break;
            case 2:
                UIService.HeaderOutPut("TYPE OF USER");
                UIService.lineOutput("1- Enterprise");
                UIService.lineOutput("2- Common");
                UIService.FooterOutput();
                int typeOfUser = UIService.getUserOption();
                Class<?> type = getTypeOfUser(typeOfUser);
                if(type == null){
                    UIService.errorOutput("Invalid option!");
                }else{
                    User newUser = UIService.getUserData(type);
                    if(newUser != null){
                        UsersDAO.saveUser(newUser);
                        UIService.sucessOutput("User successfully created!");
                    }
                }
                break;
            case 3:
                UIService.otherOutput("Closing...");
                break;
            case 9:
                //TODO: Remove after DB implementation
                UsersDAO.setLoggedUser(UsersDAO.getUsers().get(0));
                UsersDAO.getLoggedUser().setAccount(new Saving(1L, UsersDAO.getLoggedUser()));
                HomeMenu.doHomeMenu();
                break;
            default:
                UIService.errorOutput("Invalid option!");
                break;
        }
    }

    public static void doLoginMenu(){
        int option;
        do{
            UIService.welcomeHeader();
            UIService.HeaderOutPut("INITIAL MENU");
            UIService.lineOutput("1 - Login");
            UIService.lineOutput("2 - Register account");
            UIService.lineOutput("3 - Exit");
            UIService.FooterOutput();
            option = UIService.getUserOption();
            doOption(option);
        }while (option != 3);
    }

    private static Class<?> getTypeOfUser(int option){
        return switch (option) {
            case 1 -> Enterprise.class;
            case 2 -> CommonUser.class;
            default -> null;
        };
    }
}
