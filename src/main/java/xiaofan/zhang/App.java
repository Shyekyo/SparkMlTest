package xiaofan.zhang;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}
