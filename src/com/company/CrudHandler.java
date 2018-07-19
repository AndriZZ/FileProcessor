package com.company;

public class CrudHandler {

    public String[] insertInPosition(String[] input, int line, int index, int numInsert){
        StringBuilder replacedST = new StringBuilder(String.valueOf(input[line]));
        replacedST.insert(index,numInsert);
        input[line]= String.valueOf(replacedST);
        return input;

    }
    public char readInPosition(String[] input, int line, int index){
        StringBuilder replacedST = new StringBuilder(String.valueOf(input[line]));
        System.out.println(replacedST.charAt(index));
        return replacedST.charAt(index);
    }
    public String[] modifyInPosition(String[] input, int line, int numModify,int index){
        StringBuilder replacedST = new StringBuilder(String.valueOf(input[line]));
        replacedST.setCharAt(index, Character.forDigit(numModify,10));
        input[line]= String.valueOf(replacedST);
        return input;
    }
    public String[] removeInPosition(String[] input, int line, int index){
        StringBuilder replacedST = new StringBuilder(String.valueOf(input[line]));
        replacedST.delete(index,index+1);
        input[line]= String.valueOf(replacedST);
        return input;

    }
}
