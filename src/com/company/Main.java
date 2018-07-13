package com.company;

import java.io.*;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.nio.file.Paths;


public class Main {
    static String[] contentUSE;
   static String[] strings;
   static String content;
    static String filename;



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

        new pickFile();
        new getUserInput();




    }
}