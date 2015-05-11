package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 06.05.2015.
 */
public class Square<T extends Number> extends UnaryOperation<T> {
    public Square(TripleExpression<T> exp, Mode<T> mode) {
        super(exp, mode);
    }
    public T evaluate(int x, int y, int z) throws Exception {
        calculate(x, y, z);
        return mode.square(res);
    }
}
