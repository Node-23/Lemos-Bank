package com.forja.Services;

import com.forja.Models.CommonUser;
import com.forja.Models.Enterprise;
import com.forja.Models.User;

import java.util.Scanner;

public class UIService {
    private static final Scanner input = new Scanner (System.in);
    private static int headerSize;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int getUserOption(){
        return input.nextInt();
    }

    public static String getUserInput(){
        return input.nextLine();
    }
    public static void resetInput(){
        input.nextLine();
    }

    public static void HeaderOutPut(String menuName){
        clearConsole();
        headerSize = 28 + menuName.length();
        System.out.println("*------------" + menuName + "--------------*");
    }

    public static void FooterOutput(){
        String lineLength = "-".repeat(headerSize-2);
        System.out.println("*" + lineLength + "*\n");
    }

    public static User Login(){
        UIService.resetInput();
        UIService.HeaderOutPut("LOGIN");
        UIService.lineOutput("Email:");
        String email = UIService.getUserInput();
        UIService.lineOutput("Password:");
        String password = UIService.getUserInput();
        UIService.FooterOutput();
        return UserService.doLogin(email, password);
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
        UIService.lineOutput("Your CPF:");
        String cpf = UIService.getUserInput();
        UIService.lineOutput("Your password:");
        String password = UIService.getUserInput();
        UIService.FooterOutput();
        return (CommonUser) UserService.RegisterUser(name, email, password, address, phoneNumber, cpf, CommonUser.class);
    }

    public static Enterprise CreateEnterpriseUser() {
        UIService.resetInput();
        UIService.HeaderOutPut("REGISTER USER");
        UIService.lineOutput("Business name:");
        String name = UIService.getUserInput();
        UIService.lineOutput("Your email:");
        String email = UIService.getUserInput();
        UIService.lineOutput("Your address:");
        String address = UIService.getUserInput();
        UIService.lineOutput("Your phoneNumber:");
        String phoneNumber = UIService.getUserInput();
        UIService.lineOutput("Your CNPJ:");
        String cnpj = UIService.getUserInput();
        UIService.lineOutput("Your password:");
        String password = UIService.getUserInput();
        UIService.FooterOutput();
        return (Enterprise) UserService.RegisterUser(name, email, password, address, phoneNumber, cnpj, Enterprise.class);
    }

    public static void welcomeHeader(){
        System.out.print("\n\n ##-- WELCOME TO LEMOS BANK --##\n\n");
    }

    public static void lineOutput(String text){
        System.out.println(text.trim());
    }

    public static void errorOutput(String text){
        System.out.println(ANSI_RED + text.trim() + ANSI_RESET);
    }
    public static void warningOutput(String text){
        System.out.println(ANSI_YELLOW + text.trim() + ANSI_RESET);
    }
    public static void sucessOutput(String text){
        System.out.println(ANSI_GREEN + text.trim() + ANSI_RESET);
    }
    public static void otherOutput(String text){
        System.out.println(ANSI_BLUE + text.trim() + ANSI_RESET);
    }

}