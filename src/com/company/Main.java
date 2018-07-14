package com.company;
import java.io.*;
import static com.company.GetUserInput.filename;

public class Main {

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


    public static void main(String[] args) throws IOException {

        FileContentReader b=new FileContentReader();
        b.requireFile();
        b.readFileContent(filename);
        GetUserInput a= new GetUserInput();
        a.getUserInput();

    }
}