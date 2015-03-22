package info.kgeorgiy.courses.java_intro.homeworks.hw5;

/**
 * Created by Abduqodir on 22.03.2015.
 */
public class Variable implements Expression, DoubleExpression {

    public Variable(String varName) {
    }

    public int evaluate(int value) {
        return value;
    }

    public double evaluate(double value) {
        return value;
    }
}
