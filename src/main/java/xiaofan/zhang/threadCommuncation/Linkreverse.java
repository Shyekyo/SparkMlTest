package xiaofan.zhang.threadCommuncation;

/**
 * Created by zhangxiaofan on 2019/5/27.
 */
public class Linkreverse {
    static class Node{
        int val;
        Node next;
        Node(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = getNode();

        Node reverse = test(head);
        while(reverse.next!=null){
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
        System.out.println(reverse.val);
    }
    public static Node reverse(Node head){
        Node pre = null;
        Node cur = head;
        Node headNone = null;
        while(cur!=null){
            Node next = cur.next;
            if(next==null){
                headNone = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return headNone;
    }

    public static Node getNode(){
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        return node;
    }
    public static Node test(Node head){
        Node pre = null;
        Node cur = head;
        Node headCur = null;
        while(cur!=null){
            Node next = cur.next;
            if(next==null){
                headCur = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return headCur;
    }
}
