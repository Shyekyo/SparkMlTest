package xiaofan.zhang.threadCommuncation;

/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class JobB extends Thread{

    private Subject subject;
    public JobB(Subject subject) {
        this.subject=subject;
    }
    @Override
    public void run() {
        try {
            new JobA().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            this.subject.doB();
        }
    }
}
