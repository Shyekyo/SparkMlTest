package xiaofan.zhang.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by zhangxiaofan on 2019/6/7.
 */
public class demo7 {
    public static void main(String[] args) throws FileNotFoundException {
        String path ="D:\\GITRepo\\SparkMlTest\\src\\main\\resources\\a.txt";
        File file = new File(path);
        System.out.println(file.length());
        RandomAccessFile randomAccessFile = new RandomAccessFile(file,"r");
    }
}
