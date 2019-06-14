package xiaofan.zhang.demo;

import java.io.IOException;

/**
 * Created by zhangxiaofan on 2019/6/14.
 */
public class demo15 {
    public static void main(String[] args) throws IOException {
        String com = "C:\\Users\\SongHyeKyo\\Desktop\\chat\\start_autoChat.vbs";
        String[] Cmd  = new String[]{"wscript.exe", com};
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec(Cmd);
        System.out.println(exec.isAlive());
        try {
            int i = exec.waitFor();
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(exec.isAlive());
    }
}
