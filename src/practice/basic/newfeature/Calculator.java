package practice.basic.newfeature;

/**
 * @author Steve Zou
 */
public class Calculator {
    public int calculate(int a, int b, Calculation formula) {
        return formula.calculate(a, b);
    }
}
