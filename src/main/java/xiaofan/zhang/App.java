package xiaofan.zhang;

import scala.math.Ordering;

import javax.script.ScriptEngineManager;
import java.io.File;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*mp();
        //int jc = jc(5);
        int num = 50;
        int[] ints = new int[100];
        ints[ints.length-1]=1;
        print(ints);
        for (int i = 1; i <= num; i++) {
            ints = cheng(ints,i);
        }
        print(ints);
        int[] arr = new int[]{2,3,5,6,4,7,9,7};
        //int[] arr = new int[]{3,2,5,6,7,9,1};
        int[] ints = insertSort2(arr);
        print(ints);
        int[] arr = new int[]{2,3,5,6,7,8,9,10};
        int i = searchB2(arr, 10, 0, arr.length);
        System.out.println(i);
        listDir(new File("."));
        int run = run(6);
        System.out.println(run);
        int run2 = run2(6);
        System.out.println(run2);
        int[] arr = new int[]{3,2,5,6,7,9,1,1};
        int[] ints = sort(arr,0,arr.length-1);
        print(ints);
        int[] arr = new int[]{1,2,3,6,8,5,19,20,16,4,2,7,13,9,11};
        heapSort(arr);
        int[] arr = new int[]{1,2,3,6,8,5,19,20,16,4,2,7,13,9,11};
        int[] sort = insertSort(arr);
        print(sort);*/
    }

    private static int[] cheng(int[] ints,int num) {

        for (int i = 0; i <ints.length ; i++) {
            ints[i]=ints[i]*num;
        }
        for (int i = ints.length-1; i > 0; i--) {
            ints[i-1] = ints[i-1]+(ints[i]/10);
            ints[i]=ints[i]%10;
        }
        return ints;
    }
    public static void print(int[] ints) {
        StringBuffer sb = new StringBuffer(100);
        for (int i = 0; i < ints.length; i++) {
            sb.append(ints[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
    private static int jc(int num) {
       int reslut = 1;
       if(num<0){
            throw new IllegalArgumentException();
       }
       if(num==1){
           return 1;
       }else{
           reslut=num*jc(num-1);
           return reslut;
       }
    }

    private static void mp() {
        int[] arr = {4,5,1,2,6,8};
        System.out.println("arr length: " + arr.length);
        for (int i = 0; i <arr.length-1; i++) {         //6
            for (int j = 0; j < arr.length-1-i; j++) {    //6
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        print(arr);
    }
    private static int[] insertSort(int[] arr) {
        //2,3,5,6,4,7,9,7
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]<arr[i-1]){
                for (int j = 0; j < i; j++) {
                    if(arr[i]<arr[j]){
                        for (int k = j; k <i ; k++) {
                            int tmp = arr[i];
                            arr[i]=arr[k];
                            arr[k]=tmp;
                        }
                    }
                }
            }
        }
        return arr;
    }
    //1 两两比较，如果前一位大于后一位，则进入循环，比较前几位和当前位置大小
    //2 如果当前位置小于前几位的某位置，则交换位置，并第一次循环的下标减减，重新再次比较
    private static int[] insertSort2(int[] arr) {
        //2,3,5,6,4,7,9,7
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]<arr[i-1]){
                for (int j = 0; j < i; j++) {
                    if(arr[i]<arr[j]) {
                        int tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                        i--;
                    }
                }
            }
        }
        return arr;
    }
    private static int searchB(int[] arr,int snum,int start ,int end) {
        //searchB(arr, 10,0,arr.length)
        //2,3,5,6,7,8,9,10
        if(start>end) return -1;
        int maddle = (end+start) / 2;
        if(arr[maddle]==snum) return maddle;
        if(arr[maddle]>snum){
            start = 0;
            end = maddle-1;
            return searchB(arr,snum,start,end);
        }else{
            start = maddle+1;//4
            end = end-1;//8
            return searchB(arr,snum,start,end);
        }
    }
    private static int searchB2(int[] arr,int snum,int start ,int end) {
        //searchB(arr, 10,0,arr.length)
        //2,3,5,6,7,8,9,10
        int s = 0;
        int e =arr.length-1;
        int m = 0;
        while(s<=e){
            m=(s+e)/2;
            if(arr[m]==snum){
                return m;
            }else if(arr[m]>snum){
                e = m-1;
            }else{
                s = m+1;
            }
        }
        return -1;
    }
    private static void listDir(File file) {
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (int i = 0; i <files.length ; i++) {
                if(files[i].isDirectory()){

                    listDir(files[i]);
                }else{
                    System.out.println(files[i].getName());
                }
            }
        }else{
            System.out.println(file.getName());
        }
    }

    private static void consoleFile(String fileDir, int num) {
        File file = new File(fileDir);
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
        if (files == null) {// 如果目录为空，直接退出
            return;
        }
        // 遍历，目录下的所有文件
        for (File f : files) {
            if (f.isDirectory()) {
                consoleSplit(f.getAbsolutePath(), num);
                consoleFile(f.getAbsolutePath(), num + 1);
            } else if (f.isFile()) {
                consoleSplit(f.getAbsolutePath(), num);
            }
        }
    }

    private static void consoleSplit(String fileName, int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("|========");
        }
        System.out.println(fileName);
    }

    public static int run(int n){
        if(n==1||n==2){
            return 1;
        }else{
            return run(n-1)+run(n-2);
        }
    }
    public static int run2(int n){
        int num1 = 1;
        int num2 = 1;
        int num3=0;
        if(n==1||n==2){
            return 1;
        }
        for (int i = 3; i <=n ; i++) {
            num3 = num1+num2;
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }
    public static int[] sort(int[] arr,int s,int e){
        //3,2,5,6,7,9,1
        if(s<e){
            int index = quickSort(arr,s,e);
            sort(arr,s,index-1);
            sort(arr,index+1,e);
        }
        return arr;
    }
    public static int quickSort(int[] arr,int s ,int e){
        //4,7,9,7,2,3,5,6
        int mark = arr[s];
        while(s<e){
            while(s<e){
                //3,7,9,7,2,3,5,6
                if(mark>arr[e]){
                    arr[s]=arr[e];
                    break;
                }
                e--;
            }
            //3,7,9,7,2,7,5,6
            while(s<e){
                if(arr[s]>=mark){
                    arr[e]=arr[s];
                    break;
                }
                s++;
            }
        }
        arr[s]=mark;
        return s;
    }
    //7,9,7,5,6 mark=7
    //6,9,7,5,6
    //6,5,7,7,9
    //

    //父节点=（size-1）/2
    //1,2,3,6,8,5,19,20,16,4,2,7,13,9,11
    //5,7,2,5,8,9,3,4,6
    public static int[] heapSort(int[] arr){
        for (int i = (arr.length-1)/2; i >0 ; i--) {
            System.out.println(arr[i]);
            //先找到最大的儿子
        }
        return arr;
    }

}
