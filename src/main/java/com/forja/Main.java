package com.forja;

import com.forja.Services.UIService;

import static com.forja.Views.LoginMenu.doOption;


public class Main {
    public static void main(String[] args) {
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
}