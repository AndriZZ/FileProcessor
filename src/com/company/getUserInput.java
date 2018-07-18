package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static com.company.Main.printMenu;

public class GetUserInput  {
    public static void main(String[] args){}
    static String[] contentUSE;
    static String[] strings;
    static String content;
    static String filename;

    void getUserInput() throws IOException {
        Character userOption = null;
        do {

            for (int i = 0; i < contentUSE.length - 1; i++) {
                System.out.println(contentUSE[i]);
                if (i==contentUSE.length-2) printMenu();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            userOption = (char) br.read();
            switch (userOption) {
                case 'a' | 'A':
                    FileUtilities.validate(content);
                    break;
                case 'b':
                    BufferedReader as = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("Enter 1st num");
                    int a = Integer.parseInt(as.readLine());
                    System.out.print("Enter 2nd num");
                    int b = Integer.parseInt(as.readLine());
                    Swap.swapLines(contentUSE, a, b);
                    break;
                case 'c':
                    BufferedReader az = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("Put in this line");
                    int line1 = Integer.parseInt(az.readLine());
                    System.out.print("This index");
                    int num1 = Integer.parseInt(az.readLine());
                    System.out.print("Take from this line");
                    int line2 = Integer.parseInt(az.readLine());
                    System.out.print("This index");
                    int num2 = Integer.parseInt(az.readLine());

                    Swap.swapNumber(contentUSE, num1, line1, num2, line2);
                    break;
                case 'd':
                    String str = String.join("", contentUSE);
                    FileUtilities.writeToFile(filename, str);
                    break;
                case 'e':
                    BufferedReader ab = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("Insert in line:");
                    int line = Integer.parseInt(ab.readLine());
                    System.out.print("Insert in index:");
                    int index = Integer.parseInt(ab.readLine());
                    System.out.print("Insert number:");
                    int num = Integer.parseInt(ab.readLine());
                    Crud.insertInPosition(contentUSE, line, index, num);
                    break;
                case 'f':
                    BufferedReader an = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("Read line:");
                    int linen = Integer.parseInt(an.readLine());
                    System.out.print("Read index:");
                    int indexn = Integer.parseInt(an.readLine());
                    Crud.readInPosition(contentUSE, linen, indexn);
                    break;
                case 'g':
                    BufferedReader am = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("Line modify:");
                    int linem = Integer.parseInt(am.readLine());
                    System.out.print("Index modify:");
                    int indexm = Integer.parseInt(am.readLine());
                    System.out.print("Number to place:");
                    int numM = Integer.parseInt(am.readLine());
                    Crud.modifyInPosition(contentUSE, linem, numM, indexm);
                    break;
                case 'h':
                    BufferedReader ak = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("Line to delete in:");
                    int linek = Integer.parseInt(ak.readLine());
                    System.out.print("Index delete:");
                    int indexk = Integer.parseInt(ak.readLine());
                    Crud.removeInPosition(contentUSE, linek, indexk);
                    break;
                default:
                    System.out.println("Enter A-E");
            }

        }
        while (userOption != 'Z');

    }

}
