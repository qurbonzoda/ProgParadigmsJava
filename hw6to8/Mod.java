package info.kgeorgiy.courses.java_intro.homeworks.hw6to8;

/**
 * Created by Abduqodir on 30.03.2015.
 */
public class Mod extends BinaryOperation {

    public Mod(TripleExpression exp1, TripleExpression exp2) {
        super(exp1, exp2);
    }

    public int evaluate(int x, int y, int z) throws Exception {
        super.calculate(x, y, z);
        return res1 % res2;
    }
}
