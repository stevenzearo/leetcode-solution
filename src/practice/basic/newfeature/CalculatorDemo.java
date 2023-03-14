package practice.basic.newfeature;

/**
 * @author Steve Zou
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(1, 2, (int a, int b) -> a + b));
    }
}
