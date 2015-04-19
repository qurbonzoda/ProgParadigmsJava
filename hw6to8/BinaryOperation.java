package info.kgeorgiy.courses.java_intro.homeworks.hw6;

/**
 * Created by Abduqodir on 22.03.2015.
 */
public abstract class BinaryOperation implements TripleExpression {
    TripleExpression exp1, exp2;
    int res1, res2;

    public BinaryOperation(TripleExpression exp1, TripleExpression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    public void calculate(int x, int y, int z) {
        res1 = exp1.evaluate(x, y, z);
        res2 = exp2.evaluate(x, y, z);
    }
}
