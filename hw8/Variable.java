package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 22.03.2015.
 */
class Variable<T extends Number> implements TripleExpression<T> {
    private String name;
    Mode<T> mode;
    public Variable(String name, Mode<T> mode) {
        this.name = name;
        this.mode = mode;
    }

    public T evaluate(int x, int y, int z) throws Exception {
        switch (name) {
            case "x":
                return mode.variable(x);
            case "y":
                return mode.variable(y);
            default:
                return mode.variable(z);
        }
    }
}
