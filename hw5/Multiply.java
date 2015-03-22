package info.kgeorgiy.courses.java_intro.homeworks.hw5;

/**
 * Created by Abduqodir on 22.03.2015.
 */
public class Multiply extends BinaryOperation/* implements DoubleExpression*/ {

    public Multiply(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }


    public int evaluate(int value) {
        return exp1.evaluate(value) * exp2.evaluate(value);
    }
/*
    public double evaluate(double value) {
        return exp1.evaluate(value) * exp2.evaluate(value);
    }
    */
}
