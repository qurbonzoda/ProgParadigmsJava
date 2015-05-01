package info.kgeorgiy.courses.java_intro.homeworks.hw6to8;


/**
 * Created by Abduqodir on 22.03.2015.
 */
public class CheckedDivide extends BinaryOperation {

    public CheckedDivide(TripleExpression exp1, TripleExpression exp2) {
        super(exp1, exp2);
    }

    public int evaluate(int x, int y, int z) throws Exception {
        super.calculate(x, y, z);
        if (res2 == 0) {
            throw new ArithmeticException("division by zero");
        }
        if (res1 == Integer.MIN_VALUE && res2 == -1) {
            throw new ArithmeticException("overflow");
        }
        return res1 / res2;
    }
}
