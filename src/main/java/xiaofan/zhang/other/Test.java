package xiaofan.zhang.other;

/**
 * Created by zhangxiaofan on 2019/5/4.
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,6,4,7,9,7};
        int[] arr1 = new int[]{2,3,4,4,5,7,7,9};
        //int fb = fb(arr, 5);
        //System.out.println(fb);
        //int jicheng = jicheng(5);
        //System.out.println(jicheng);
        //int[] m = m(arr);
        //App.print(m);
        insertSort(arr);
        //int index = search(arr1, 9, 0, 7);
        //System.out.println(index);
    }

    private static int search(int[] arr, int num,int start,int end) {
        int mid = (start+end)/2;
        if(start > end){
            return -1;
        }else{
            if(arr[mid]>num){
                end = mid-1;
                return search(arr,num,start,end);
            }else if(arr[mid]<num){
                start = mid+1;
                return search(arr,num,start,end);
            }else{
                return mid;
            }
        }
    }

    private static int [] insertSort(int[] arr) {
        //2,3,5,6,4,7,9,7
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>arr[i-1]){
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

    private static int[] m(int[] arr) {
        for (int i = 0; i <arr.length-1; i++) {
            for (int j = 0; j <arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    private static int jicheng(int num) {
        int reslut = 0;
        if(num<0){
            throw new IllegalArgumentException();
        }
        if(num == 1){
            return 1;
        }else {
            reslut = num * jicheng(num - 1);
            return reslut;
        }
    }

    private static int fb(int[] arr, int n) {
        int num1 = 1;
        int num2 = 1;
        int num3 = 0;
        while (n>2){
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            n--;
        }
        return num3;
    }
}
