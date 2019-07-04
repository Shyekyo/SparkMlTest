package xiaofan.zhang.other;

/**
 * Created by zhangxiaofan on 2019/4/9.
 */
public class Node {
    Object value = null;
    Node next = null;

    public Node() {
    }
    public Node(Object obj) {
        this.value = obj ;
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

    public static void main(String[] args) {
        int k =3;
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        head.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        del(k,head);

        Node tmp = head;
        while(tmp!=null){
            System.out.println(tmp.value);
            tmp=tmp.next;
        }

    }
    //k = 2
    //1,2,3,4,5
    public static void del(int k,Node head){
        Node[] arrk = new Node[k];
        int index =0;
        Node tmp = head;
        while (tmp != null) {
            if(k>index){
                arrk[index]=tmp;
            }else{
                for (int i = 0; i <arrk.length-1 ; i++) {
                    arrk[i] = arrk[i+1];
                }
                arrk[k-1]=tmp;
            }
            index++;
            tmp = tmp.next;
        }
        arrk[0].value=arrk[0].next.value;
        arrk[0].next=arrk[0].next.next;
    }
}
