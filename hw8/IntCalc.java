package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 05.05.2015.
 */
public class IntCalc implements Mode<Integer> {
    public Integer add(Integer a, Integer b) throws Exception {
        if ((a > 0 && b > Integer.MAX_VALUE - a) || (a < 0 && b < Integer.MIN_VALUE - a)) {
            throw new ArithmeticException("overflow");
        }
        return a + b;
    }

    public Integer subtract(Integer a, Integer b) throws Exception {
        if ((a >= 0 && (b == Integer.MIN_VALUE || -b > Integer.MAX_VALUE - a)) || (a < 0 && b != Integer.MIN_VALUE && -b < Integer.MIN_VALUE - a)) {
            throw new ArithmeticException("overflow");
        }
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) throws  Exception {
        if ((b != 0 && a != a * b / b) || (a != 0 && b != a * b / a)) {
            throw new ArithmeticException("overflow");
        }
        return a * b;
    }

    public Integer divide(Integer a, Integer b) throws Exception {
        if (b == 0) {
            throw new ArithmeticException("division by zero");
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new ArithmeticException("overflow");
        }
        return a / b;
    }

    public Integer mod(Integer a, Integer b) throws Exception {
        try {
            return a % b;
        } catch (Exception e) {
            throw new InvalidExpression("division by zero");
        }
    }

    public Integer abs(Integer a) throws Exception {
        if (a == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow");
        }
        return a < 0 ? -a : a;
    }

    public Integer square(Integer a) throws Exception {
        return multiply(a, a);
    }

    public Integer negate(Integer a) throws Exception {
        return multiply(a, -1);
    }

    public Integer toConst(String s) throws Exception {
        try {
            return Integer.parseUnsignedInt(s);
        } catch (Exception e) {
            throw new InvalidExpression(s + "is too large for Integer");
        }
    }

    public Integer variable(int value) throws Exception {
        return value;
    }
}
