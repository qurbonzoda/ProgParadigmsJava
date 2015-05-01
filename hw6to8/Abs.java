package info.kgeorgiy.courses.java_intro.homeworks.hw6to8;

/**
 * Created by Abduqodir on 20.04.2015.
 */
public class Abs extends UnaryOperation {
    public Abs(TripleExpression exp) {
        super(exp);
    }
    public int evaluate(int x, int y, int z) throws Exception {
        calculate(x, y, z);
        if (res == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow");
        }
        return res < 0 ? -res : res;
    }
}
