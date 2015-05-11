package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 20.04.2015.
 */
class Abs<T extends Number> extends UnaryOperation<T> {
    public Abs(TripleExpression<T> exp, Mode<T> mode) {
        super(exp, mode);
    }
    public T evaluate(int x, int y, int z) throws Exception {
        calculate(x, y, z);
        return mode.abs(res);
    }
}
