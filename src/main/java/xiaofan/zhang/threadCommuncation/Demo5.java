package xiaofan.zhang.threadCommuncation;

/**
 * Created by zhangxiaofan on 2019/6/7.
 */
public class Demo5 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    if(i%2==0){
                        System.out.println(i);
                        Thread.yield();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    if(i%2!=0){
                        System.out.println(i);
                        //Thread.yield();
                    }
                }
            }
        }).start();
    }
}
