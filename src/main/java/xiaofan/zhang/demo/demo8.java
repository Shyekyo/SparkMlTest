package xiaofan.zhang.demo;

/**
 * Created by zhangxiaofan on 2019/6/7.
 */
public class demo8 {

        public static long t=0;

        public static class ChangT implements Runnable{

            private long to;

            public ChangT(long to) {
                this.to = to;
            }
            @Override
            public void run() {
                while (true){
                    demo8.t = to;
                    Thread.yield();
                }
            }
        }

        public static class ReadT implements Runnable{
            @Override
            public void run() {

                while (true){
                    long tmp = demo8.t;
                    if (tmp != 111L && tmp != -999L && tmp != 333L && tmp != -444L)
                        System.out.println(tmp);
                    Thread.yield();
                }
            }
        }

        public  static void main(String[] a){

            new Thread(new ChangT(111L)).start();
            new Thread(new ChangT(-999L)).start();
            new Thread(new ChangT(333L)).start();
            new Thread(new ChangT(-444L)).start();
            new Thread(new ReadT()).start();

        }
    }

