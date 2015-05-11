package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 14.04.2015.
 */
class CheckedNegate<T extends Number> extends UnaryOperation<T> {
    public CheckedNegate(TripleExpression<T> exp, Mode<T> mode) {
        super(exp, mode);
    }

    public T evaluate(int x, int y, int z) throws Exception {
        calculate(x, y, z);
        return mode.negate(res);
    }
}
