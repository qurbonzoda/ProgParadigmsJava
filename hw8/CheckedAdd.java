package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 22.03.2015.
 */
class CheckedAdd<T extends Number> extends BinaryOperation<T> {

    public CheckedAdd(TripleExpression<T> exp1, TripleExpression<T> exp2, Mode<T> mode) {
        super(exp1, exp2, mode);
    }

    public T evaluate(int x, int y, int z) throws Exception {
        calculate(x, y, z);
        return mode.add(res1, res2);
    }
}
