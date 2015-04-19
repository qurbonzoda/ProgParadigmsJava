package info.kgeorgiy.courses.java_intro.homeworks.hw6;

/**
 * Created by Abduqodir on 22.03.2015.
 */
public class Variable implements TripleExpression {
    private String name;
    public Variable(String name) {
        this.name = name;
    }

    public int evaluate(int x, int y, int z) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            default:
                return z;
        }
    }
}
