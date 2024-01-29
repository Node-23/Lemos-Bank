package com.forja.Services;

import java.util.Scanner;

public class UIService {
    private static final Scanner input = new Scanner (System.in);
    private static final int TEXT_MAX_SIZE = 28;

    public static int getUserOption(){
        return input.nextInt();
    }

    public static String getUserInput(){
        return input.nextLine();
    }

    public static void HeaderOutPut(){
        System.out.println("*------------****--------------*");
    }

    public static void FooterOutput(){
        System.out.println("*------------------------------*\n");
    }

    public static void welcomeHeader(){
        System.out.print("\n\n ##-- WELCOME TO LEMOS BANK --##\n\n");
    }

    public static void lineOutput(String text){
        String data = "";
        if(text.trim().length() <= TEXT_MAX_SIZE){
            data += "| " + text.trim() +
                    fillWithSpace(TEXT_MAX_SIZE - text.trim().length()) +
                    " |";
        }else{
            int linesCount = (int) Math.ceil((double) text.length() / TEXT_MAX_SIZE);
            String[] arr = new String[linesCount];

            for (int i = 0; i < linesCount; i++) {
                arr[i] = text.substring(i * (TEXT_MAX_SIZE -1), Math.min((i + 1) * (TEXT_MAX_SIZE -1), text.length()));
            }

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                output.append("| ").append(arr[i]).append(i == arr.length-1? fillWithSpace(TEXT_MAX_SIZE - arr[i].length()) + " |":"- |\n");
            }
            data += output.toString();
        }
        System.out.println(data);
    }

    private static String fillWithSpace(int spaceCount){
        return " ".repeat(spaceCount);
    }
}