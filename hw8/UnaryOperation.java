package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 20.04.2015.
 */
abstract class UnaryOperation<T extends Number> implements TripleExpression<T> {
    protected TripleExpression<T> exp;
    protected Mode<T> mode;
    protected T res;
    protected UnaryOperation(TripleExpression<T> exp, Mode<T> mode) {
        this.exp = exp;
        this.mode = mode;
    }
    protected void calculate(int x, int y, int z) throws Exception {
        res = exp.evaluate(x, y, z);
    }
}
