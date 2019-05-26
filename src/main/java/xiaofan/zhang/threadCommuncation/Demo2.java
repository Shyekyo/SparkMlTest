package xiaofan.zhang.threadCommuncation;

/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class Demo2 {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i = 0; i <3 ; i++) {
                        System.out.println(i);
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println(1);
                    System.out.println(2);
                    System.out.println(3);
                    o.notifyAll();
                }

            }
        }).start();

        int a =0;
        System.out.println( a++);
    }
}
