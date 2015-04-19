package info.kgeorgiy.courses.java_intro.homeworks.hw6;

import java.io.IOException;

/**
 * Created by Abduqodir on 22.03.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new ExpressionParser();
        String s = "1 + 5 mod 3";
        TripleExpression exp = parser.parse(s);
        System.out.println("Here we go :");
        System.out.println(exp.evaluate(1, 2, 3));
    }
}
