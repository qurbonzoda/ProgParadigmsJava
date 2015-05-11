package info.kgeorgiy.courses.java_intro.homeworks.hw8;

import java.math.BigInteger;

/**
 * Created by Abduqodir on 06.05.2015.
 */
public class BigIntCalc implements Mode<BigInteger> {
    public BigInteger add(BigInteger a, BigInteger b) throws Exception {
        return a.add(b);
    }

    public BigInteger subtract(BigInteger a, BigInteger b) throws Exception {
        return a.subtract(b);
    }

    public BigInteger multiply(BigInteger a, BigInteger b) throws  Exception {
        return a.multiply(b);
    }

    public BigInteger divide(BigInteger a, BigInteger b) throws Exception {
        try {
            return a.divide(b);
        } catch (Exception e) {
            throw new InvalidExpression("division by zero");
        }
    }

    public BigInteger mod(BigInteger a, BigInteger b) throws Exception {
        BigInteger tmp = new BigInteger("1");
        if (a.compareTo(new BigInteger("0")) < 0) {
            tmp = negate(tmp);
        }
        return multiply(tmp, abs(a).mod(abs(b)));
    }

    public BigInteger abs(BigInteger a) throws Exception {
        return a.abs();
    }

    public BigInteger square(BigInteger a) throws Exception {
        return multiply(a, a);
    }

    public BigInteger negate(BigInteger a) throws Exception {
        return multiply(a, new BigInteger("-1"));
    }

    public BigInteger toConst(String s) throws Exception {
        return new BigInteger(s);
    }

    public BigInteger variable(int value) throws Exception {
        return new BigInteger(Integer.toString(value));
    }
}
