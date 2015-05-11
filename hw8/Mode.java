package info.kgeorgiy.courses.java_intro.homeworks.hw8;

/**
 * Created by Abduqodir on 05.05.2015.
 */
public interface Mode<T extends Number> {
    T add(T exp1, T exp2) throws Exception;
    T subtract(T exp1, T exp2) throws Exception;
    T multiply(T exp1, T exp2) throws Exception;
    T divide(T exp1, T exp2) throws Exception;
    T mod(T exp1, T exp2) throws Exception;
    T abs(T exp1) throws Exception;
    T square(T exp1) throws Exception;
    T negate(T exp1) throws Exception;
    T toConst(String value) throws Exception;
    T variable(int value) throws Exception;
}
