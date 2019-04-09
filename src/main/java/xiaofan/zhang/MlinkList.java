package xiaofan.zhang;

/**
 * Created by zhangxiaofan on 2019/4/9.
 */
public class MlinkList {
    public static void main(String[] args) {
        MlinkList m = new MlinkList();
        m.add("a");
        m.add("b");
        m.add("c");
        m.get(0);
        m.set(1,5);
        m.get(1);
        m.get(2);
        m.removeAt(2);
        m.get(1);
    }

    int size =0;
    public MlinkList() {

    }
    Node head=null;
    public void add(Object obj) {
        Node newNode = new Node();
        newNode.setValue(obj);
        if(head==null){
            head=newNode;
        }else {
            Node next = head;
            while (next.getNext()!=null) {
                next = next.getNext();
            }
            next.setNext(newNode);
        }
        size++;
    }
    public int size(){
        return size;
    }
    public void get(int index) {
        Node temp = head;
        for (int i = 0; i <size ; i++) {
            if(i==index){
                System.out.println(temp.getValue());
                break;
            }
            temp = temp.getNext();
        }
    }
    public void set(int index ,Object obj) {
        Node temp = head;
        for (int i = 0; i <size ; i++) {
            if(i==index){
                temp.setValue(obj);
            }
            temp = temp.getNext();
        }
    }
    public void removeAt(int index) {
        if(index==0){
            head = head.getNext();
        }else{
            Node temp = head;
            for (int i = 0; i <index-1 ; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        size--;
    }
}
