package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        Data data = new Data(str);

        System.out.println("Первое число " + data.getFirstNumber());
        System.out.println("Второе число " + data.getSecondNumber());
        System.out.println("Оператор " + data.getOperator());

        System.out.println(Calculator.calculate(data.getFirstNumber(),data.getSecondNumber(),data.getOperator()));

        /*System.out.println(Arrays.toString(Roman.values()));


        System.out.println("Введите число");
        String str = in.nextLine();

        String[] str2 = Data.ParseData(str);

        for (String s: str2
             ) {
            System.out.println(s);
        }*/

        //System.out.println("Оператор  " + Data.getChar(str));

        //System.out.println("Число равно = " + Data.romanToInt(Data.trimAll(str)));

        /*System.out.println("Введите операцию");

        ch = Calculator.read(in);

        for(int i : ch){
            System.out.println((char)i);
        }

        System.out.println(Charset.defaultCharset());
	// write your code here*/
    }

}
