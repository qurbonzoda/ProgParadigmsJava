package info.kgeorgiy.courses.java_intro.homeworks.hw3;

/**
 * Created by Abduqodir on 03.03.2015.
 */
public class ArrayQueueADT {
    private int size, left, right;
    private Object[] elements = new Object[10];
    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert  element != null;

        ensureCapacity(queue, queue.left, queue.right);
        queue.elements[queue.right] = element;
        queue.right = (queue.right + 1) % queue.elements.length;
        queue.size++;
    }
    public static void ensureCapacity(ArrayQueueADT queue, int l, int r) {
        if(l != r || queue.size == 0) {
            return;
        }
        Object[] newElements = new Object[queue.size * 2];
        for (int i = 0; i < queue.size; i++) {
            newElements[i] = queue.elements[(queue.left + i) % queue.elements.length];
        }
        queue.elements = newElements;
        queue.left = 0;
        queue.right = queue.size;
    }
    public static Object[] toArray(ArrayQueueADT queue) {
        Object[] newElements = new Object[queue.size];
        for (int i = 0; i < queue.size; i++) {
            newElements[i] = queue.elements[(queue.left + i) % queue.elements.length];
        }
        return newElements;
    }
    public static Object element(ArrayQueueADT queue) {
        assert queue.size > 0;
        return queue.elements[queue.left];
    }
    public static Object dequeue(ArrayQueueADT queue) {
        Object result = element(queue);
        queue.left = (queue.left + 1) % queue.elements.length;
        queue.size--;
        return result;
    }
    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }
    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }
    public static void clear(ArrayQueueADT queue) {
        queue.elements = new Object[10];
        queue.left = queue.right = queue.size = 0;
    }
}
