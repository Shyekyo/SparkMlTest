package xiaofan.zhang;

import scala.math.Ordering;

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
        print(ints);*/
        int[] arr = new int[]{2,3,5,6,7,8,9,10};
        int i = searchB2(arr, 10, 0, arr.length);
        System.out.println(i);
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
    private static void print(int[] ints) {
        StringBuffer sb = new StringBuffer(100);
        for (int i = 0; i < ints.length; i++) {
            sb.append(ints[i]);
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

}
