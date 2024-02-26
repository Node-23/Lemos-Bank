package com.forja.Views;

import com.forja.DAO.UsersDAO;
import com.forja.Services.UIService;

import java.math.BigDecimal;

public class HomeMenu {

    public static void doHomeMenu(){
        while(true){
            UIService.HeaderOutPut("WELCOME " + UsersDAO.getLoggedUser().getName());
            UIService.lineOutput("1- See balance");
            UIService.lineOutput("2- Withdraw");
            UIService.lineOutput("3- Deposit");
            UIService.lineOutput("4- Make a transfer");
            UIService.lineOutput("5- Logout");
            UIService.FooterOutput();
            int option = UIService.getUserOption();
            if(option == 5){
                break;
            }else{
                doOption(option);
            }
        }
    }

    public static void doOption(int option){
        switch (option){
            case 1:
                seeBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                break;
            default:
                UIService.errorOutput("Invalid option!");
                break;
        }
    }

    public static void seeBalance(){
        UIService.HeaderOutPut("BALANCE");
        UIService.lineOutput("Your balance is:");
        UIService.lineOutput("L$ "+UsersDAO.getLoggedUser().getAccount().getBalance().toString());
        UIService.FooterOutput();
    }

    public static void withdraw(){
        UIService.HeaderOutPut("WITHDRAW");
        UIService.lineOutput("How much do you want to withdraw?");
        BigDecimal value = UIService.getUserValue();
        if(UsersDAO.getLoggedUser().getAccount().withdraw(value)){
            UIService.sucessOutput("Withdraw of " + value + " successfully done");
        }
        UIService.FooterOutput();
    }

    public static void deposit(){
        UIService.HeaderOutPut("DEPOSIT");
        UIService.lineOutput("How much do you want to deposit?");
        BigDecimal value = UIService.getUserValue();
        if(UsersDAO.getLoggedUser().getAccount().deposit(value)){
            UIService.sucessOutput("Deposit of " + value + " successfully done");
        }
        UIService.FooterOutput();
    }
}
