package info.kgeorgiy.courses.java_intro.homeworks.hw5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Abduqodir on 22.03.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(reader.readLine());
        System.out.println(new Add(
                                new Subtract(
                                    new Multiply(
                                            new Variable("x"),
                                            new Variable("x")
                                    ),
                                    new Multiply(
                                            new Const(2),
                                            new Variable("x")
                                    )
                                ),
                                new Const(1)
                            ).evaluate(value));
    }
}
