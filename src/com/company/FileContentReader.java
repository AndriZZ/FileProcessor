package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileContentReader  {
   public String[] contentUSE;
   private String[] strings;
   public String content;
   public String filename;

    public String requireFile() throws IOException {
        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
        UserInteractionHandler userInteractionHandler=new UserInteractionHandler(buffer);
        userInteractionHandler.outputMessage("Enter a file name: ");
        filename = userInteractionHandler.readFilenameInput();
        return filename;

    }
    public String[] readFileContent(String filename) throws IOException {
        FileUtilities fileUtilities =new FileUtilities();
        content = new String(Files.readAllBytes(Paths.get(filename)));
        int numberLines = fileUtilities.countLines(filename)+2;
        Alternator alternator = new Alternator();
        strings = alternator.turnFileIntoArrayOfStrings(content,numberLines);
        contentUSE = strings;
        return strings;
    }

}
