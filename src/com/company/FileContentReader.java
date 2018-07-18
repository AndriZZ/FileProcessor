package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileContentReader extends GetUserInput {

    public String requireFile() throws IOException {
        System.out.print("Enter a file name: ");
        UserInteractionHandler userInteractionHandler=new UserInteractionHandler();
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
