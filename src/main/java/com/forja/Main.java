package com.forja;

import com.forja.Services.UIService;

public class Main {
    public static void main(String[] args) {
        UIService.welcomeHeader();
        UIService.HeaderOutPut();
        UIService.lineOutput("1 - Login");
        UIService.lineOutput("2 - Register account");
        UIService.lineOutput("3 - Exit");
        UIService.FooterOutput();
        int option = UIService.getUserOption();
    }
}