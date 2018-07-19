package com.company;

import java.io.BufferedReader;
import java.io.IOException;


public class UserInteractionHandler
{
   private BufferedReader buffer;
    public UserInteractionHandler(BufferedReader buffer){
        this.buffer=buffer;
    }

    public Integer getIntegerInput() throws IOException {
        String s=buffer.readLine();
        Integer line=Integer.parseInt(s);
        return line;
    }
    public Character getCharacterInput() throws IOException {

        Character line=(char) buffer.read();
        return line;
    }

    public String readFilenameInput() throws IOException {

        String line=buffer.readLine();
        return line;
    }
    public void outputMessage(String text){
        System.out.print(text);
    }

    public void printMenu() {
        this.outputMessage(
                "Type A to validate content\n"+
                "Type B to switch lines content"+"Type C to switch number at specific index\n"+
                "Type D to save contents in initial file\n"+
                "Type E to insert a number in a given position\n"+
                "Type F to read a number in a given position\n"+
                "Type G to modify a number in a given position\n"+
                "Type H to remove a number in a given position\n");
    }
}
