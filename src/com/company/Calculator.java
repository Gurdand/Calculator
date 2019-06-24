package com.company;

public class Calculator {

    public static int calculate(int firstNumber, int secondNumber, char operator){

        switch (operator){
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                return firstNumber / secondNumber;
        }
        return -1;
    }

}
