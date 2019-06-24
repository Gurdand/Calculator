package com.company;

public class Data {

    private String inputString;

    public Data(String inputString){
        this.inputString = inputString;
    }

    protected int getFirstNumber(){
        if (Character.isLetter(inputString.charAt(0))){
            return romanToInt(parseData(inputString)[0]);
        }else {
            return Integer.parseInt(parseData(inputString)[0]);
        }
    }

    protected int getSecondNumber(){
        if (Character.isLetter(inputString.charAt(0))){
            return romanToInt(parseData(inputString)[1]);
        }else {
            return Integer.parseInt(parseData(inputString)[1]);
        }
    }

    protected char getOperator(){

        char sim = ' ';

        for(char ch: inputString.toCharArray()) {
            if(ch == '+'||ch == '-'||ch == '/'||ch == '*' ){
                return ch;
            }
        }

        return sim;
    }

    private String[] parseData(String string) {
        String[] str = string.split("[+-/*]");
        return str;
    }

    /*public static char getChar(String string){

        char sim = ' ';

        for(char ch: string.toCharArray()) {
            if(ch == '+'||ch == '-'||ch == '/'||ch == '*' ){
                return ch;
            }
        }

        return sim;
    }*/

    private String trimAll(String string){
        char[] ch = string.toCharArray();
        StringBuilder str = new StringBuilder();
        for (char sim: ch){
            if (sim == 32){
                continue;
            }
            str.append(sim);
        }
        return str.toString();
    }

    private int romanToInt(String str){
        int num;
        for (Roman i: Roman.values()) {
            if (i.toString().equals(str)) {
                num = i.ordinal() + 1;
                return num;
            }
        }
        return -1;
    }
}
