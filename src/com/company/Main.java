package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите данные:");

        // Считывание строки
        String str = in.nextLine();

        try{

            // Подготовка данных
            Data data = new Data(str);

            // Подсчет и вывод результата
            System.out.println(Calculator.calculate(data.firstNumber(), data.secondNumber(), data.operator()));

        }catch (CalculatorException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }

}
