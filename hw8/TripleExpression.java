package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 22.03.2015.
 */
interface TripleExpression<T extends Number> {
    T evaluate(int x, int y, int z) throws Exception;
}
