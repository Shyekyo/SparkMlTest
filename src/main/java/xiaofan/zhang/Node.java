package xiaofan.zhang;

/**
 * Created by zhangxiaofan on 2019/4/9.
 */
public class Node {
    Object value = null;
    Node next = null;

    public Node() {
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
