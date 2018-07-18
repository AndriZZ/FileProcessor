package com.company;

public class Swapper {
    public  String[] swapLines(String[] input, int index1, int index2) {
        String temp;
        temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
        return input;
    }

    public String[] swapNumber(String[] input, int index1, int line1, int index2, int line2) {
        char numCopy = input[line2].charAt(index2);
        StringBuilder replacedST = new StringBuilder(String.valueOf(input[line1]));
        replacedST.setCharAt(index1, numCopy);
        System.out.println(replacedST);
        input[line1] = String.valueOf(replacedST);
        return input;

    }
}
