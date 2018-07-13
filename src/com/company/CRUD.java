package com.company;

public class CRUD {

    public static String[] InsertInPosition(String[] input, int line, int index, int numInsert){
        StringBuilder replacedST = new StringBuilder(String.valueOf(input[line]));
        replacedST.insert(index,numInsert);
        input[line]= String.valueOf(replacedST);
        return input;

    }
    public static char ReadInPosition(String[] input, int line, int index){
        StringBuilder replacedST = new StringBuilder(String.valueOf(input[line]));
        System.out.println(replacedST.charAt(index));
        return replacedST.charAt(index);
    }
    public static String[] ModifyInPosition(String[] input, int line, int numModify,int index){
        StringBuilder replacedST = new StringBuilder(String.valueOf(input[line]));
        replacedST.setCharAt(index, Character.forDigit(numModify,10));
        input[line]= String.valueOf(replacedST);
        return input;
    }
    public static String[] RemoveInPosition(String[] input, int line, int index){
        StringBuilder replacedST = new StringBuilder(String.valueOf(input[line]));
        replacedST.delete(index,index+1);
        input[line]= String.valueOf(replacedST);
        return input;

    }
}
