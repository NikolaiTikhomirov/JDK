package calcArraysPair;

/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract(). Параметры этих методов – два
числа разного типа, над которыми должна быть произведена операция.
*/

public class Calculator {

    public static <K> Double sum (K num1, K num2){
        return Double.valueOf(num1.toString()) + Double.valueOf(num2.toString());
    }

    public static <K> Double multiply (K num1, K num2){
        return Double.valueOf(num1.toString()) * Double.valueOf(num2.toString());
    }

    public static <K> Double divide (K num1, K num2){
        return Double.valueOf(num1.toString()) / Double.valueOf(num2.toString());
    }

    public static <K> Double subtract (K num1, K num2){
        return Double.valueOf(num1.toString()) - Double.valueOf(num2.toString());
    }
}
