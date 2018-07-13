package com.company;

import java.io.*;
import java.util.Scanner;

public class Alter {

    public static String[] turnFileIntoArrayOfStrings(String content, int lines) {
        String[] array = new String[lines];
        int index = 0;
        int tempInt = 0;
        int startIndext = 0;
        int lastIndex = content.length() - 1;
        while (true) {
            if (content.charAt(index) == '\n') {
                tempInt++;
                String temp2 = new String();
                for (int i = 0; i < index - startIndext; i++) {
                    temp2 += content.charAt(startIndext + i);
                }
                startIndext = index;
                array[tempInt - 1] = temp2;
            }
            if (index == lastIndex) {
                tempInt++;
                String temp2 = new String();
                for (int i = 0; i < index - startIndext + 1; i++) {
                    temp2 += content.charAt(startIndext + i);
                }
                array[tempInt - 1] = temp2;
                break;
            }
            index++;
        }
        return array;
    }
}
