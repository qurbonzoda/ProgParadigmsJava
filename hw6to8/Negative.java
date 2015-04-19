package info.kgeorgiy.courses.java_intro.homeworks.hw6;

/**
 * Created by Abduqodir on 14.04.2015.
 */
public class Negative implements TripleExpression {
    TripleExpression result;
    public Negative(TripleExpression exp) {
        result = exp;
    }
    public int evaluate(int x, int y, int z) {
        return -result.evaluate(x, y, z);
    }
}
