package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 06.05.2015.
 */
public class DoubleCalc implements Mode<Double> {
    public Double add(Double a, Double b) throws Exception {
        return a + b;
    }

    public Double subtract(Double a, Double b) throws Exception {
        return a - b;
    }

    public Double multiply(Double a, Double b) throws  Exception {
        return a * b;
    }

    public Double divide(Double a, Double b) throws Exception {
        return a / b;
    }

    public Double mod(Double a, Double b) throws Exception {
        try {
            return a % b;
        } catch (Exception e) {
            throw new InvalidExpression("division by zero");
        }
    }

    public Double abs(Double a) throws Exception {
        return a < 0 ? -a : a;
    }

    public Double square(Double a) throws Exception {
        return multiply(a, a);
    }

    public Double negate(Double a) throws Exception {
        return multiply(a, -1.0);
    }

    public Double toConst(String s) throws Exception {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            throw new InvalidExpression(s + " is too large for Double");
        }
    }

    public Double variable(int value) throws Exception {
        return (double)value;
    }
}
