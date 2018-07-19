package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetUserInput  {
    void getUserInput() throws IOException {
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
                    fileUtilities.validate(fileContentReader.content);
                    break;
                case 'b':
                    userInteractionHandler.outputMessage("Enter 1st num");
                   int a=userInteractionHandler.getIntegerInput();
                    userInteractionHandler.outputMessage("Enter 2nd num");
                   int b = userInteractionHandler.getIntegerInput();
                    swapper.swapLines(fileContentReader.contentUSE, a, b);
                    break;
                case 'c':
                    System.out.print("Put in this line");
                    int line1 = userInteractionHandler.getIntegerInput();
                    userInteractionHandler.outputMessage("This index");
                    int num1 = userInteractionHandler.getIntegerInput();
                    userInteractionHandler.outputMessage("Take from this line");
                    int line2 =userInteractionHandler.getIntegerInput();
                    userInteractionHandler.outputMessage("This index");
                    int num2 =userInteractionHandler.getIntegerInput();
                    swapper.swapNumber(fileContentReader.contentUSE, num1, line1, num2, line2);
                    break;
                case 'd':
                    String updatedString = String.join("", fileContentReader.contentUSE);
                    fileUtilities.writeToFile(fileContentReader.filename, updatedString);
                    break;
                case 'e':
                    userInteractionHandler.outputMessage("Insert in line:");
                    int line = userInteractionHandler.getIntegerInput();
                    userInteractionHandler.outputMessage("Insert in index:");
                    int index = userInteractionHandler.getIntegerInput();
                    userInteractionHandler.outputMessage("Insert number:");
                    int num = userInteractionHandler.getIntegerInput();
                    crudHandler.insertInPosition(fileContentReader.contentUSE, line, index, num);
                    break;
                case 'f':
                    userInteractionHandler.outputMessage("Read line:");
                    int lineF = userInteractionHandler.getIntegerInput();
                    userInteractionHandler.outputMessage("Read index:");
                    int indexF = userInteractionHandler.getIntegerInput();
                    crudHandler.readInPosition(fileContentReader.contentUSE, lineF, indexF);
                    break;
                case 'g':
                    userInteractionHandler.outputMessage("Line modify:");
                    int lineG = userInteractionHandler.getIntegerInput();
                    userInteractionHandler.outputMessage("Index modify:");
                    int indexG = userInteractionHandler.getIntegerInput();
                    userInteractionHandler.outputMessage("Number to place:");
                    int numM = userInteractionHandler.getIntegerInput();
                    crudHandler.modifyInPosition(fileContentReader.contentUSE, lineG, numM, indexG);
                    break;
                case 'h':
                    userInteractionHandler.outputMessage("Line to delete in:");
                    int lineH = userInteractionHandler.getIntegerInput();
                    userInteractionHandler.outputMessage("Index delete:");
                    int indexH = userInteractionHandler.getIntegerInput();
                    crudHandler.removeInPosition(fileContentReader.contentUSE, lineH, indexH);
                    break;
                default:
                    System.out.println("Enter A-E");
            }

        }
        while (userOption != 'Z');
        buffer.close();

    }

}
