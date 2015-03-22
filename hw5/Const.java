package info.kgeorgiy.courses.java_intro.homeworks.hw5;

/**
 * Created by Abduqodir on 22.03.2015.
 */
public class Const implements  Expression/*, DoubleExpression*/ {
    int value;
    double DoubleValue;

    public Const(int value) {
        this.value = value;
    }

    public Const(double value) {
        DoubleValue = value;
    }

    public int evaluate(int value) {
        return this.value;
    }
/*
    public double evaluate(double value) {
        return DoubleValue;
    }
    */
}
