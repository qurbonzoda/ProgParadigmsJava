package info.kgeorgiy.courses.java_intro.homeworks.hw4;

/**
 * Created by Abduqodir on 03.03.2015.
 */
public class ArrayQueue extends AbstractQueue {
    private int left, right;
    private Object[] elements = new Object[10];
    public void enqueue(Object element) {
        assert  element != null;

        ensureCapacity(left, right);
        elements[right] = element;
        right = (right + 1) % elements.length;
        size++;
    }
    public void ensureCapacity(int l, int r) {
        if(l != r || size == 0) {
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
    public Object element() {
        assert size > 0;
        return elements[left];
    }
    public Object dequeue() {
        Object result = element();
        left = (left + 1) % elements.length;
        size--;
        return result;
    }
    public void clear() {
        elements = new Object[10];
        left = right = size = 0;
    }
    public Object[] toArray() {
        Object[] newElements = new Object[size];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(left + i) % elements.length];
        }
        return newElements;
    }
}
