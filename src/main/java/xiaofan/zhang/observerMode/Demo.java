package xiaofan.zhang.observerMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class Demo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new OctObserver(subject);
        new HexObserver(subject);
        new BinObserver(subject);
        subject.setState(10);
        //[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
        System.out.println("==============");
        int[] arr = new int[]{1,4,7,11,15,0,0,0};
        int[] arr1 = {12,17,18};
        int n=5;
        int m=3;
        int total = m+n-1;
        while(m>0){
           arr[total]=arr1[m-1];
           total--;
           m--;
        }

        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }

    }

    public static int majorityElement(int[] nums) {
        Integer result = null;
        int len = nums.length/2;
        if(len==1){
            return nums[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer num:nums){
            if(map.get(num)==null){
                map.put(num,1);
            }else{
                Integer count = map.get(num)+1;
                map.put(num,count);
                if(count>=len){
                    result = num;
                    break;
                }
            }
        }
        return result;
    }

    public boolean hsearch(int[][] arr,int target,int start,int end){
        int mid = (start+end)/2;
        if(arr[mid][0]>target){
            for(int i = 0;i<mid;i++){
                return wsearch(arr[i],target,start,end);
            }
        }else if(arr[mid][0]<target){
            for(int j = mid+1;j<end;j++){
                return wsearch(arr[j],target,start,end);
            }
        }else{
            return true;
        }
        return false;

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int hight = matrix.length;
        if(hight==0) return false;
        int weight = matrix[0].length;
        boolean index = false;
        for(int i = 0;i<hight;i++){
            index = wsearch(matrix[i],target,0,weight-1);
        }
        return index;
    }


    public static boolean wsearch(int[] arr,int target,int start,int end){
        int mid = (start+end)/2;
        if(start>end) return false;
        if(target>arr[mid]){
            start = mid+1;
            return wsearch(arr,target,start,end);
        }else if(target<arr[mid]){
            end = mid-1;
            return wsearch(arr,target,start,end);
        }else{
            return true;
        }
    }
}
