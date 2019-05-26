package xiaofan.zhang.other;

import java.util.concurrent.FutureTask;

/**
 * Created by zhangxiaofan on 2019/5/3.
 */
public class DeadLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) throws InterruptedException {
//        Thread a = new Thread(new Lock1());
//        Thread b = new Thread(new Lock2());
//        a.start();
//        b.start();
        Object lock = new Object();
        final boolean[] flag = {true};//交替执行标志位。true-线程1运行，false-线程2运行
        FutureTask task1 = new FutureTask(() -> {
            for (int i = 0; i < 50; i++) {
                synchronized (lock) {
                    while (true) {
                        if (flag[0]) {
                            System.out.print(i * 2 + 1 + ",");
                            flag[0] = false;
                            lock.notify();
                            if (i < 49) {//打印完最后一个，不需要再wait了。
                                lock.wait();
                            }
                            break;
                        }
                    }
                }
            }
            return null;
        });
        Thread t1 = new Thread(task1);

        FutureTask task2 = new FutureTask(() -> {
            for (int i = 0; i < 50; i++) {
                synchronized (lock) {
                    while (true) {
                        if (!flag[0]) {
                            System.out.print(i * 2 + 2 + ",");
                            flag[0] = true;
                            lock.notify();
                            if (i < 49) {//打印完最后一个，不需要再wait了。
                                lock.wait();
                            }
                            break;
                        } else {
                            lock.wait();
                        }
                    }
                }
            }
            return null;
        });
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.print("finished");
    }


    class Lock1 implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Lock1 running");
                while (true) {
                    synchronized (DeadLock.obj1) {
                        System.out.println("Lock1 lock obj1");
                        Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                        synchronized (DeadLock.obj2) {
                            System.out.println("Lock1 lock obj2");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class Lock2 implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Lock2 running");
                while (true) {
                    synchronized (DeadLock.obj2) {
                        System.out.println("Lock2 lock obj2");
                        Thread.sleep(3000);
                        synchronized (DeadLock.obj1) {
                            System.out.println("Lock2 lock obj1");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
