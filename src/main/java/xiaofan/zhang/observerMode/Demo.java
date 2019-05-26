package xiaofan.zhang.observerMode;

/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class Demo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new OctObserver(subject);
        new HexObserver(subject);
        new BinObserver(subject);
        subject.setState(10);
        System.out.println("==============");
        subject.setState(19);
    }
}
