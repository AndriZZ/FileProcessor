package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class pickFile extends Main {

     pickFile() throws IOException {

        System.out.print("Enter a file name: ");
        Scanner s = new Scanner(System.in);
        filename = s.nextLine();

        content = new String(Files.readAllBytes(Paths.get(filename)));
        int numberLines = FileUtilities.countLines("some.txt")+2;
        strings = Alter.turnFileIntoArrayOfStrings(content,numberLines);
        contentUSE = strings;
    }

}
