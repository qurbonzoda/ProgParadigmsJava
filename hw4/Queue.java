package info.kgeorgiy.courses.java_intro.homeworks.hw4;

/**
 * Created by Abduqodir on 04.03.2015.
 */
public interface Queue {
    void enqueue(Object element);
    Object[] toArray();
    Object element();
    Object dequeue();
    int size();
    boolean isEmpty();
    void clear();
}
