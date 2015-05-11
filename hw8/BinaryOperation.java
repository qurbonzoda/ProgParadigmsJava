package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 22.03.2015.
 */
abstract class BinaryOperation<T extends Number> implements TripleExpression<T> {
    protected TripleExpression<T> exp1, exp2;
    protected Mode<T>mode;
    protected T res1, res2;

    public BinaryOperation(TripleExpression<T> exp1, TripleExpression<T> exp2, Mode<T> mode) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.mode = mode;
    }
    public void calculate(int x, int y, int z) throws Exception {
        res1 = exp1.evaluate(x, y, z);
        res2 = exp2.evaluate(x, y, z);
    }
}
