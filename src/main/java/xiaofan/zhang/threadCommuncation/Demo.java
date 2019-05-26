package xiaofan.zhang.threadCommuncation;

/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class Demo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Thread jobA = new Thread(new JobA(subject));
        Thread jobB = new Thread(new JobB(subject));
        jobA.start();
        jobB.start();
    }
}
