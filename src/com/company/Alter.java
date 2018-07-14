package com.company;

public class Alter {

    public static String[] turnFileIntoArrayOfStrings(String content, int lines) {
        String[] array = new String[lines];
        int index = 0;
        int tempInt = 0;
        int startIndex = 0;
        int lastIndex = content.length() - 1;
        while (true) {
            if (content.charAt(index) == '\n') {
                tempInt++;
                String temp2 = new String();
                for (int i = 0; i < index - startIndex; i++) {
                    temp2 += content.charAt(startIndex + i);
                }
                startIndex = index;
                array[tempInt - 1] = temp2;
            }
            if (index == lastIndex) {
                tempInt++;
                String temp2 = new String();
                for (int i = 0; i < index - startIndex + 1; i++) {
                    temp2 += content.charAt(startIndex + i);
                }
                array[tempInt - 1] = temp2;
                break;
            }
            index++;
        }
        return array;
    }
}
