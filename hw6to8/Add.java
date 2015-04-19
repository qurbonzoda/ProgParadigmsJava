package info.kgeorgiy.courses.java_intro.homeworks.hw6;

/**
 * Created by Abduqodir on 22.03.2015.
 */
public class Add extends BinaryOperation {

    public Add(TripleExpression exp1, TripleExpression exp2) {
        super(exp1, exp2);
    }

    public int evaluate(int x, int y, int z) {
        super.calculate(x, y, z);
        return res1 + res2;
    }
}