package com.company;

/**
 * Класс извлекает данные из строки, проверяет на допустимость значений,
 * и создает объект, содержащий подготовленные данные для класса Calculator.
 */

public class Data {

    private int firstNumber;
    private int secondNumber;
    private char operator = ' ';

    public Data(String string) throws CalculatorException{

        String inputString = trimAll(string); //Подготовка строки

        if (Character.isLetter(inputString.charAt(0))){ // Если рмские цифры
            firstNumber = romanToInt(parseData(inputString)[0]);
            secondNumber = romanToInt(parseData(inputString)[1]);

        }else if (checkInt(parseData(inputString))){ // Если арабские цифры
            firstNumber = Integer.parseInt(parseData(inputString)[0]);
            secondNumber = Integer.parseInt(parseData(inputString)[1]);
        }else {
            throw new CalculatorException("Введены неверные данные!");
        }
        // Проверка на допустимые значения
        if (firstNumber <= 0 || firstNumber > 10) throw new CalculatorException("Неверные данные!");
        if (secondNumber <= 0 || secondNumber > 10) throw new CalculatorException("Неверные данные!");

        // Извлечения знака оператора
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

    /**
     * Извлекает из строки числа
     * @param string
     * @return Возвращает массив из 2 чисел в строковом представлении
     * @throws CalculatorException Если введено неверное кол-во чисел или операторов
     */
    private String[] parseData(String string) throws CalculatorException{
        String[] str = string.split("[+-/*]");

        if (str.length != 2) throw new CalculatorException("Неверные данные!");

        return str;
    }

    /**
     * Проверяет строки на возможность конвертации в числа (для Integer.parseInt)
     * @param array
     * @return true если все числа
     */
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

    /**
     * Убирает все пробелы из строки (для метода parseData)
     * @param string
     * @return
     */
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

    /**
     * Заменяет римскую цифру на арабскую в пределах списка Roman
     * @param str
     * @return Возвращает integer эквивалент римской цифры
     */
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
