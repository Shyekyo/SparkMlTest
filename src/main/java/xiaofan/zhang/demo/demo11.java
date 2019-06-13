package xiaofan.zhang.demo;

/**
 * Created by zhangxiaofan on 2019/6/9.
 */
public class demo11 implements Runnable{
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("group");
        Thread thread = new Thread(threadGroup,new demo11(),"1");
        Thread thread1 = new Thread(threadGroup,new demo11(),"2");
        thread.start();
        thread1.start();
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = threadGroup.activeCount();
        System.out.println(i);

    }

    @Override
    public void run() {
        System.out.println(11);
    }
}
