package com.company;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {

        FileContentReader fileContentReader=new FileContentReader();
        String filename=fileContentReader.requireFile();
        fileContentReader.readFileContent(filename);
        GetUserInput getUserInput= new GetUserInput();
        getUserInput.getUserInput();

    }
}