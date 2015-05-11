package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 25.03.2015.
 */

interface Parser<T extends Number> {
    TripleExpression<T> parse(String expression) throws Exception;
}
