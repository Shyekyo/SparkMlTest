package xiaofan.zhang.threadCommuncation;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class Demo4 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        final Random ran = new Random();
        for(char threadname='a';threadname<='c';threadname++){
            String s = String.valueOf(threadname);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = ran.nextInt(10)*100;
                    System.out.println(s + " need "+i);
                    try {
                        Thread.sleep(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println(s + " wait...");
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(s + "  running");
                }
            }).start();
        }
    }
}
