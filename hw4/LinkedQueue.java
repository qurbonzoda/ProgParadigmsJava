package info.kgeorgiy.courses.java_intro.homeworks.hw4;

/**
 * Created by Abduqodir on 04.03.2015.
 */
public class LinkedQueue extends AbstractQueue {
    private Node head, tail;

    public void enqueue(Object value) {
        head = new Node(value, head);
        if(size == 0) {
            tail = head;
        }
        size++;
    }
    public Object element() {
        assert size > 0;
        return tail.value;
    }
    public Object dequeue() {
        Object result = element();
        tail = tail.prev;
        size--;
        return result;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public Object[] toArray() {
        Object[] result = new Object[size];
        Node iter = tail;
        for(int i = 0; i < size; i++, iter = iter.prev) {
            result[i] = iter.value;
        }
        return result;
    }
}
