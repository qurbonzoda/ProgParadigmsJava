package info.kgeorgiy.courses.java_intro.homeworks.hw4;

/**
 * Created by Abduqodir on 04.03.2015.
 */
public abstract class AbstractQueue implements Queue {
    int size;
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
