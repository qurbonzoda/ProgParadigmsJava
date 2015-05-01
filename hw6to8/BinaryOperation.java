package info.kgeorgiy.courses.java_intro.homeworks.hw6to8;

/**
 * Created by Abduqodir on 22.03.2015.
 */
public abstract class BinaryOperation implements TripleExpression {
    protected TripleExpression exp1, exp2;
    protected int res1, res2;

    public BinaryOperation(TripleExpression exp1, TripleExpression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    public void calculate(int x, int y, int z) throws Exception {
        res1 = exp1.evaluate(x, y, z);
        res2 = exp2.evaluate(x, y, z);
    }
    public static int addOverflow(int a, int b) throws Exception {
        if ((a > 0 && b > Integer.MAX_VALUE - a) || (a < 0 && b < Integer.MIN_VALUE - a)) {
            //System.out.println(a + " + " + b);
            throw new ArithmeticException("overflow");
        }
        return a + b;
    }
    public static int subtractOverflow(int a, int b) throws Exception {
        if ((a >= 0 && (b == Integer.MIN_VALUE || -b > Integer.MAX_VALUE - a)) || (a < 0 && b != Integer.MIN_VALUE && -b < Integer.MIN_VALUE - a)) {
            //System.out.println(a + " - " + b);
            throw new ArithmeticException("overflow");
        }
        return a - b;
    }
}
