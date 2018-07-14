package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileContentReader extends GetUserInput {

    public void requireFile(){
        System.out.print("Enter a file name: ");
        Scanner s = new Scanner(System.in);
        filename = s.nextLine();

    }
    public void readFileContent(String filename) throws IOException {

        content = new String(Files.readAllBytes(Paths.get(filename)));
        int numberLines = FileUtilities.countLines(filename)+2;
        strings = Alter.turnFileIntoArrayOfStrings(content,numberLines);
        contentUSE = strings;
    }

}
