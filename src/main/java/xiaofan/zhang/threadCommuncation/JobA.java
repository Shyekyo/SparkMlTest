package xiaofan.zhang.threadCommuncation;


/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class JobA extends Thread{

    private Subject subject;
    public JobA() {

    }
    public JobA(Subject subject) {
        this.subject=subject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            this.subject.doA();
        }
    }
}
