import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

/*
С помощью объекта DescriptiveStatistics вычислить минимальное и
максимальное значение, сумму и среднее арифметическое.

Воспользоваться пакетом org.apache.commons.math3.util. С помощью класса
ArithmeticUtils найти :
○ факториал числа N.
○ Наименьшее общее частное двух чисел
○ Наибольший общий делитель двух чисел
○ Проверить что число N это степень двойки
 */
public class Main {
    public static void main(String[] args) {
        double[] array = {12., 5., 55., 23., 98., 10.};
        DescriptiveStatistics statistics = new DescriptiveStatistics(array);
        System.out.println("min value = " + statistics.getMin());
        System.out.println("max value = " + statistics.getMax());
        System.out.println("sum = " + statistics.getSum());
        System.out.printf("average value = %.2f\n", statistics.getMean());

        System.out.println("Factorial 5 = " + ArithmeticUtils.factorial(5));
        System.out.println("GCD(77, 35) = " + ArithmeticUtils.gcd(77, 35));
        System.out.println("LCM(77, 35) = " + ArithmeticUtils.lcm(77, 35));
        System.out.println("IsPowerOfTwo(256) = " + ArithmeticUtils.isPowerOfTwo(256));
        System.out.println("IsPowerOfTwo(122) = " + ArithmeticUtils.isPowerOfTwo(122));
    }
}
