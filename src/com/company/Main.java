package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите данные:");

        String str = in.nextLine();

        try{

        Data data = new Data(str);

            // For tests
            /*System.out.println("Первое число " + data.firstNumber());
            System.out.println("Второе число " + data.secondNumber());
            System.out.println("Оператор " + data.operator());*/

            System.out.println(Calculator.calculate(data.firstNumber(), data.secondNumber(), data.operator()));

        }catch (CalculatorException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }

}
