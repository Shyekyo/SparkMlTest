package xiaofan.zhang.threadCommuncation;

/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class Subject {

    synchronized public void doA(){
        System.out.println("doA");
    }

    synchronized public void doB(){
        System.out.println("doB");
    }
}
