package com.company;

/**
 *
 */

public class Data {

    private int firstNumber;
    private int secondNumber;
    private char operator = ' ';

    public Data(String string) throws CalculatorException{

        String inputString = trimAll(string);

        if (Character.isLetter(inputString.charAt(0))){
            firstNumber = romanToInt(parseData(inputString)[0]);
            secondNumber = romanToInt(parseData(inputString)[1]);
        }else if (checkInt(parseData(inputString))){
            firstNumber = Integer.parseInt(parseData(inputString)[0]);
            secondNumber = Integer.parseInt(parseData(inputString)[1]);
        }else {
            throw new CalculatorException("Введены неверные данные!");
        }
        if (firstNumber <= 0 || firstNumber > 10) throw new CalculatorException("Неверные данные!");
        if (secondNumber <= 0 || secondNumber > 10) throw new CalculatorException("Неверные данные!");

        for(char ch: inputString.toCharArray()) {
            if(ch == '+'||ch == '-'||ch == '/'||ch == '*' ){
                this.operator = ch;
                break;
            }
        }
        if (operator == ' ') throw new CalculatorException("Недопустимый оператор!");
    }

    public int firstNumber(){
        return this.firstNumber;
    }

    public int secondNumber(){
        return this.secondNumber;
    }

    public char operator(){
        return this.operator;
    }

    private String[] parseData(String string) throws CalculatorException{
        String[] str = string.split("[+-/*]");

        if (str.length != 2) throw new CalculatorException("Неверные данные!");

        return str;
    }

    private boolean checkInt(String[] array){
        for(String str: array){
            for(char ch: str.toCharArray()){
                if(Character.isLetter(ch)){
                    return false;
                }
            }
        }
        return true;
    }

    private String trimAll(String string){
        char[] charArray = string.toCharArray();
        StringBuilder str = new StringBuilder();
        for (char s: charArray){
            if (s == 32){
                continue;
            }
            str.append(s);
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
