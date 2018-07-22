package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInteractor  {

    public void interact() throws IOException {
        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
        FileContentReader fileContentReader=new FileContentReader();
        String filename=fileContentReader.requireFile();
        fileContentReader.readFileContent(filename);
        UserInteractionHandler userInteractionHandler= new UserInteractionHandler(buffer);
        Character userOption = null;

        do {

            for (int i = 0; i < fileContentReader.contentUSE.length - 1; i++) {
                System.out.println(fileContentReader.contentUSE[i]);
                if (i==fileContentReader.contentUSE.length-2) userInteractionHandler.printMenu();
            }

            userOption = userInteractionHandler.getCharacterInput();
            buffer.readLine();
            Swapper swapper=new Swapper();
            CrudHandler crudHandler=new CrudHandler();
            FileUtilities fileUtilities=new FileUtilities();
            switch (userOption) {

                case 'a' | 'A':
                    validateFileContent(fileContentReader, fileUtilities);
                    break;
                case 'b':
                    swapFileLines(fileContentReader, userInteractionHandler, swapper);
                    break;
                case 'c':
                    swapFileDigit(fileContentReader, userInteractionHandler, swapper);
                    break;
                case 'd':
                    saveFile(fileContentReader, fileUtilities);
                    break;
                case 'e':
                    insertDigitInPosition(fileContentReader, userInteractionHandler, crudHandler);
                    break;
                case 'f':
                    readDigit(fileContentReader, userInteractionHandler, crudHandler);
                    break;
                case 'g':
                    modifyInPosition(fileContentReader, userInteractionHandler, crudHandler);
                    break;
                case 'h':
                    removeInPosition(fileContentReader, userInteractionHandler, crudHandler);
                    break;
                default:
                    System.out.println("Enter A-E");
            }

        }
        while (userOption != 'Z');
        buffer.close();

    }

    private void removeInPosition(FileContentReader fileContentReader, UserInteractionHandler userInteractionHandler, CrudHandler crudHandler) throws IOException {
        int lineH = userInteractionHandler.getIntegerInput("Line to delete in:");
        int indexH = userInteractionHandler.getIntegerInput("Index delete:");
        crudHandler.removeInPosition(fileContentReader.contentUSE, lineH, indexH);
    }

    private void modifyInPosition(FileContentReader fileContentReader, UserInteractionHandler userInteractionHandler, CrudHandler crudHandler) throws IOException {
        int lineG = userInteractionHandler.getIntegerInput("Line modify:");
        int indexG = userInteractionHandler.getIntegerInput("Index modify:");
        int numM = userInteractionHandler.getIntegerInput("Number to place:");
        crudHandler.modifyInPosition(fileContentReader.contentUSE, lineG, numM, indexG);
    }

    private void readDigit(FileContentReader fileContentReader, UserInteractionHandler userInteractionHandler, CrudHandler crudHandler) throws IOException {
        int lineF = userInteractionHandler.getIntegerInput("Read line");
        int indexF = userInteractionHandler.getIntegerInput("Read index");
        crudHandler.readInPosition(fileContentReader.contentUSE, lineF, indexF);
    }

    private void insertDigitInPosition(FileContentReader fileContentReader, UserInteractionHandler userInteractionHandler, CrudHandler crudHandler) throws IOException {
        int line = userInteractionHandler.getIntegerInput("Insert in line:");
        int index = userInteractionHandler.getIntegerInput("Insert in index:");
        int num = userInteractionHandler.getIntegerInput("Insert number:");
        crudHandler.insertInPosition(fileContentReader.contentUSE, line, index, num);
    }

    private void saveFile(FileContentReader fileContentReader, FileUtilities fileUtilities) throws IOException {
        String updatedString = String.join("", fileContentReader.contentUSE);
        fileUtilities.writeToFile(fileContentReader.filename, updatedString);
    }

    private void swapFileDigit(FileContentReader fileContentReader, UserInteractionHandler userInteractionHandler, Swapper swapper) throws IOException {
        int line1 = userInteractionHandler.getIntegerInput("Put in this line");
        int num1 = userInteractionHandler.getIntegerInput("This index");
        int line2 =userInteractionHandler.getIntegerInput("Take from this line");
        int num2 =userInteractionHandler.getIntegerInput("This index");
        swapper.swapNumber(fileContentReader.contentUSE, num1, line1, num2, line2);
    }

    private void swapFileLines(FileContentReader fileContentReader, UserInteractionHandler userInteractionHandler, Swapper swapper) throws IOException {
        int a=userInteractionHandler.getIntegerInput("Enter 1st num");
        int b = userInteractionHandler.getIntegerInput("Enter 2nd num");
        swapper.swapLines(fileContentReader.contentUSE, a, b);
    }

    private void validateFileContent(FileContentReader fileContentReader, FileUtilities fileUtilities) {
        fileUtilities.validate(fileContentReader.content);
    }

}
