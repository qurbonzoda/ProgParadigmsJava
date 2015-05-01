package info.kgeorgiy.courses.java_intro.homeworks.hw6to8;

/**
 * Created by Abduqodir on 20.04.2015.
 */
public abstract class UnaryOperation implements TripleExpression {
    protected TripleExpression exp;
    protected int res;
    protected UnaryOperation(TripleExpression exp) {
        this.exp = exp;
    }
    protected void calculate(int x, int y, int z) throws Exception {
        res = exp.evaluate(x, y, z);
    }
}
