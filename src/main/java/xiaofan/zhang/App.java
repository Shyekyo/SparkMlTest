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
        mp();
        //int jc = jc(5);
        int num = 50;
        int[] ints = new int[100];
        ints[ints.length-1]=1;
        print(ints);
        for (int i = 1; i <= num; i++) {
            ints = cheng(ints,i);
        }
        print(ints);


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


}
