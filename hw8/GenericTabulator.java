package info.kgeorgiy.courses.java_intro.homeworks.hw8;

import java.math.BigInteger;

/**
 * Created by Abduqodir on 01.05.2015.
 */
public class GenericTabulator implements Tabulator {
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        Number[][][] result = new Number[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        TripleExpression<? extends Number> exp;
        switch (mode) {
            case "i":
                exp = (new CheckedParser<Integer>(new IntCalc())).parse(expression);
                break;
            case "d":
                exp = (new CheckedParser<Double>(new DoubleCalc())).parse(expression);
                break;
            case "bi":
                exp = (new CheckedParser<BigInteger>(new BigIntCalc())).parse(expression);
                break;
            default:
                throw new InvalidExpression("Unknown type");
        }
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    try {
                        result[i - x1][j - y1][k - z1] = exp.evaluate(i, j, k);
                    } catch (Exception e) {
                        /*if(i == x1 && j == y1 && k == z1)
                            System.out.println(e.getMessage());*/
                        result[i - x1][j - y1][k - z1] = null;
                    }
                }
            }
        }
        return result;
    }
}


// is T at constructors the same as in class generic T