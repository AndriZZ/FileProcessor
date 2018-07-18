package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetUserInput  {
    public static void main(String[] args){}


    void getUserInput() throws IOException {
        FileContentReader fileContentReader=new FileContentReader();
        String filename=fileContentReader.requireFile();
        fileContentReader.readFileContent(filename);
        UserInteractionHandler userInteractionHandler= new UserInteractionHandler();
        Character userOption = null;
        do {

            for (int i = 0; i < fileContentReader.contentUSE.length - 1; i++) {
                System.out.println(fileContentReader.contentUSE[i]);
                if (i==fileContentReader.contentUSE.length-2) userInteractionHandler.printMenu();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            userOption = (char) br.read();
            Swapper swapper=new Swapper();
            Crud crud=new Crud();
            FileUtilities fileUtilities=new FileUtilities();
            switch (userOption) {

                case 'a' | 'A':
                    fileUtilities.validate(fileContentReader.content);
                    break;
                case 'b':
                    System.out.print("Enter 1st num");
                    int a=userInteractionHandler.getIntegerInput();
                    System.out.print("Enter 2nd num");
                    int b = userInteractionHandler.getIntegerInput();
                    swapper.swapLines(fileContentReader.contentUSE, a, b);
                    break;
                case 'c':
                    System.out.print("Put in this line");
                    int line1 = userInteractionHandler.getIntegerInput();
                    System.out.print("This index");
                    int num1 = userInteractionHandler.getIntegerInput();
                    System.out.print("Take from this line");
                    int line2 =userInteractionHandler.getIntegerInput();
                    System.out.print("This index");
                    int num2 =userInteractionHandler.getIntegerInput();
                    swapper.swapNumber(fileContentReader.contentUSE, num1, line1, num2, line2);
                    break;
                case 'd':
                    String updatedString = String.join("", fileContentReader.contentUSE);
                    fileUtilities.writeToFile(fileContentReader.filename, updatedString);
                    break;
                case 'e':
                    System.out.print("Insert in line:");
                    int line = userInteractionHandler.getIntegerInput();
                    System.out.print("Insert in index:");
                    int index = userInteractionHandler.getIntegerInput();
                    System.out.print("Insert number:");
                    int num = userInteractionHandler.getIntegerInput();
                    crud.insertInPosition(fileContentReader.contentUSE, line, index, num);
                    break;
                case 'f':
                    System.out.print("Read line:");
                    int linen = userInteractionHandler.getIntegerInput();
                    System.out.print("Read index:");
                    int indexn = userInteractionHandler.getIntegerInput();
                    crud.readInPosition(fileContentReader.contentUSE, linen, indexn);
                    break;
                case 'g':
                    System.out.print("Line modify:");
                    int linem = userInteractionHandler.getIntegerInput();
                    System.out.print("Index modify:");
                    int indexm = userInteractionHandler.getIntegerInput();
                    System.out.print("Number to place:");
                    int numM = userInteractionHandler.getIntegerInput();
                    crud.modifyInPosition(fileContentReader.contentUSE, linem, numM, indexm);
                    break;
                case 'h':
                    System.out.print("Line to delete in:");
                    int linek = userInteractionHandler.getIntegerInput();
                    System.out.print("Index delete:");
                    int indexk = userInteractionHandler.getIntegerInput();
                    crud.removeInPosition(fileContentReader.contentUSE, linek, indexk);
                    break;
                default:
                    System.out.println("Enter A-E");
            }

        }
        while (userOption != 'Z');

    }

}
