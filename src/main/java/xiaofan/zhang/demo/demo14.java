package xiaofan.zhang.demo;

import java.util.ArrayList;

/**
 * Created by zhangxiaofan on 2019/6/10.
 */
public class demo14 {
    public static void main(String[] args) {
        demo14 demo14 = new demo14();
        int n=4;
        String s = demo14.countAndSay(n);
        System.out.println(s);
    }
    public String countAndSay(int n) {
        String sb = "1";
        int count=1;
        while(n>0){
            for (int i = 0; i <sb.length(); i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    count++;
                } else {
                    sb = count + "" + sb.charAt(i);
                    count = 1;
                }
            }
            n--;
        }
        return sb;
    }
}
