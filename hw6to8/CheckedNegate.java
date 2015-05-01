package info.kgeorgiy.courses.java_intro.homeworks.hw6to8;

/**
 * Created by Abduqodir on 14.04.2015.
 */
public class CheckedNegate implements TripleExpression {
    TripleExpression result;
    public CheckedNegate(TripleExpression exp) {
        result = exp;
    }
    public int evaluate(int x, int y, int z) throws Exception {
        int res = result.evaluate(x, y, z);
        if (res == Integer.MIN_VALUE && !(result instanceof Const) ) {
            throw new ArithmeticException("overflow");
        }
        return -res;
    }
}
