package info.kgeorgiy.courses.java_intro.homeworks.hw3;

/**
 * Created by Abduqodir on 03.03.2015.
 */
public class ArrayQueueModule {
    static int size, left, right;
    static Object[] elements = new Object[10];
    public static void enqueue(Object element) {
        assert  element != null;

        ensureCapacity();
        elements[right] = element;
        right = (right + 1) % elements.length;
        size++;
    }
    public static void ensureCapacity() {
        if(left != right || size == 0) {
            return;
        }
        Object[] newElements = new Object[size*2];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(left + i) % elements.length];
        }
        elements = newElements;
        left = 0;
        right = size;
    }
    public static Object[] toArray() {
        Object[] newElements = new Object[size];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(left + i) % elements.length];
        }
        return newElements;
    }
    public static Object element() {
        assert size > 0;
        return elements[left];
    }
    public static Object dequeue() {
        Object result = element();
        left = (left + 1) % elements.length;
        size--;
        return result;
    }
    public static int size() {
        return size;
    }
    public static boolean isEmpty() {
        return size == 0;
    }
    public static void clear() {
        elements = new Object[10];
        left = right = size = 0;
    }
}
