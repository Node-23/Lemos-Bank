package com.forja;

import com.forja.Models.CommonUser;
import com.forja.Models.Enterprise;
import com.forja.Services.UIService;
import com.forja.Services.UserService;

import static com.forja.Views.FirstMenu.doOption;


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
            UIService.resetInput();
            doOption(option);
        }while (option != 3);
    }
}