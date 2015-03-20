package info.kgeorgiy.courses.java_intro.homeworks.hw4;

/**
 * Created by Abduqodir on 06.03.2015.
 */
public class Node {
    Object value;
    Node next, prev;

    public Node(Object value, Node next) {
        assert value != null;
        this.value = value;
        this.next = next;
        if(next != null) {
            next.prev = this;
        }
    }
}
