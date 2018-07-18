package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetUserInput  {
    public static void main(String[] args){}
    static String[] contentUSE;
    String[] strings;
    static String content;
    static String filename;

    void getUserInput() throws IOException {
        UserInteractionHandler userInteractionHandler= new UserInteractionHandler();
        Character userOption = null;
        do {

            for (int i = 0; i < contentUSE.length - 1; i++) {
                System.out.println(contentUSE[i]);
                if (i==contentUSE.length-2) userInteractionHandler.printMenu();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            userOption = (char) br.read();
            Swapper swapper=new Swapper();
            Crud crud=new Crud();
            FileUtilities fileUtilities=new FileUtilities();
            switch (userOption) {

                case 'a' | 'A':
                    fileUtilities.validate(content);
                    break;
                case 'b':
                    System.out.print("Enter 1st num");
                    int a=userInteractionHandler.getIntegerInput();
                    System.out.print("Enter 2nd num");
                    int b = userInteractionHandler.getIntegerInput();
                    swapper.swapLines(contentUSE, a, b);
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
                    swapper.swapNumber(contentUSE, num1, line1, num2, line2);
                    break;
                case 'd':
                    String updatedString = String.join("", contentUSE);
                    fileUtilities.writeToFile(filename, updatedString);
                    break;
                case 'e':
                    System.out.print("Insert in line:");
                    int line = userInteractionHandler.getIntegerInput();
                    System.out.print("Insert in index:");
                    int index = userInteractionHandler.getIntegerInput();
                    System.out.print("Insert number:");
                    int num = userInteractionHandler.getIntegerInput();
                    crud.insertInPosition(contentUSE, line, index, num);
                    break;
                case 'f':
                    System.out.print("Read line:");
                    int linen = userInteractionHandler.getIntegerInput();
                    System.out.print("Read index:");
                    int indexn = userInteractionHandler.getIntegerInput();
                    crud.readInPosition(contentUSE, linen, indexn);
                    break;
                case 'g':
                    System.out.print("Line modify:");
                    int linem = userInteractionHandler.getIntegerInput();
                    System.out.print("Index modify:");
                    int indexm = userInteractionHandler.getIntegerInput();
                    System.out.print("Number to place:");
                    int numM = userInteractionHandler.getIntegerInput();
                    crud.modifyInPosition(contentUSE, linem, numM, indexm);
                    break;
                case 'h':
                    System.out.print("Line to delete in:");
                    int linek = userInteractionHandler.getIntegerInput();
                    System.out.print("Index delete:");
                    int indexk = userInteractionHandler.getIntegerInput();
                    crud.removeInPosition(contentUSE, linek, indexk);
                    break;
                default:
                    System.out.println("Enter A-E");
            }

        }
        while (userOption != 'Z');

    }

}
