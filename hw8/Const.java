package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 22.03.2015.
 */
class Const<T extends Number> implements TripleExpression<T> {
    protected String value;
    protected Mode<T> mode;
    public Const(String value, Mode<T> mode) {
        this.value = value;
        this.mode = mode;
    }

    public T evaluate(int x, int y, int z) throws Exception {
        return mode.toConst(value);
    }
}
