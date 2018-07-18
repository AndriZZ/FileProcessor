package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInteractionHandler {

    public Integer getIntegerInput() throws IOException {
        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
        Integer line=Integer.parseInt(buffer.readLine());
        return line;
    }

    public String readFilenameInput() throws IOException {
        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
        String line=buffer.readLine();
        return line;
    }

    public static void printMenu() {
        System.out.println("Type A to validate content");
        System.out.println("Type B to switch lines content");
        System.out.println("Type C to switch number at specific index");
        System.out.println("Type D to save contents in initial file");
        System.out.println("Type E to insert a number in a given position");
        System.out.println("Type F to read a number in a given position");
        System.out.println("Type G to modify a number in a given position");
        System.out.println("Type H to remove a number in a given position");
    }
}
