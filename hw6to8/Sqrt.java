package info.kgeorgiy.courses.java_intro.homeworks.hw6to8;

/**
 * Created by Abduqodir on 20.04.2015.
 */
public class Sqrt extends UnaryOperation {
    public Sqrt(TripleExpression exp) {
        super(exp);
    }
    public int evaluate(int x, int y, int z) throws Exception {
        calculate(x, y, z);
        if (res < 0) {
            throw new ArithmeticException("Error: square root of negative integer if undefined");
        }
        return (int)Math.sqrt(res);
    }
}
