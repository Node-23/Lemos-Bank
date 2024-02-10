package com.forja.Views;

import com.forja.DAO.UsersDAO;
import com.forja.Services.UIService;

public class HomeMenu {

    public static void doHomeMenu(){
        while(true){
            UIService.HeaderOutPut("WELCOME " + UsersDAO.getLoggedUser().getName());
            UIService.lineOutput("1- See balance");
            UIService.lineOutput("2- Withdraw");
            UIService.lineOutput("3- Make a transfer");
            UIService.lineOutput("4- Logout");
            UIService.FooterOutput();
            int option = UIService.getUserOption();
            if(option == 4){
                break;
            }else{
                doOption(option);
            }
        }
    }

    public static void doOption(int option){
        switch (option){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                UIService.errorOutput("Invalid option!");
                break;
        }
    }
}
