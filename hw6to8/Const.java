package info.kgeorgiy.courses.java_intro.homeworks.hw6;

/**
 * Created by Abduqodir on 22.03.2015.
 */
public class Const implements TripleExpression {
    int value;
    public Const(int value) {
        this.value = value;
    }

    public int evaluate(int x, int y, int z) {
        return value;
    }
}
