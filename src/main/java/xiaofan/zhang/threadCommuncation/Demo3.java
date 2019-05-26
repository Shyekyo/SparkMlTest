package xiaofan.zhang.threadCommuncation;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class Demo3 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(4);
            }
        }).start();
        //==========================================
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
                countDownLatch.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                countDownLatch.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(0);
                countDownLatch.countDown();
            }
        }).start();
    }
}
