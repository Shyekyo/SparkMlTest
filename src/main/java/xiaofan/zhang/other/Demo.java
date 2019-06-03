package xiaofan.zhang.other;


import java.util.HashMap;

/**
 * Created by zhangxiaofan on 2019/5/28.
 */
public class Demo {
    public static void main(String[] args) {
        int[]  nums1 = {1,2,3,0,0,0};
        int[]  nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        //merge(nums1,m,nums2,n);
        //int i = removeDuplicates4(new int[]{0,0,1,1,1,2,2,3,3,4});
        int[] ints = {1,2,2,1};
        int[] ints1 = {2,2};
        int[] delete = delete(ints, 2);
        App.print(delete);
    }
    public static int[] delete(int[] arr,int index){
        int[] newArr = new int[arr.length-1];
        for (int i = 0; i < arr.length; i++) {
            if(index>i){
                newArr[i]=arr[i];
            }else if(index<i){
                newArr[i-1]=arr[i];
            }
        }
        return newArr;
    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        int len =0;
        int index=0;
        if(nums1.length>nums2.length){
            len=nums2.length;
        }else{
            len=nums1.length;
        }
        int[] arr = new int[len];
        if(nums1==null||nums2==null){
            return new int[0];
        }
        for(int i =0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    arr[index]=nums1[i];
                    index++;
                    break;
                }
            }
        }
        int[] result = new int[index++];
        for(int x=0;x<result.length;x++){
            result[x]=arr[x];
        }
        return result;
    }
    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        //    1,2,3,4,5,6,7
        //    4,2,3,1,5,6,7
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }


    public static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int mid = (0+len-1)/2;
        if(mid<k){
            return;
        }
        for(int i=0 ;i<k;i++){
            int tmp = nums[i];
            nums[i] = nums[len-k+i];
            nums[len-k+i] = tmp;
        }
    }

    public static int maxProfit1(int[] prices) {
        int max = 0;
        int size = prices.length;
        for (int i = 0; i < size - 1; ++i){
            if (prices[i] < prices[i + 1]){
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }


    public int maxProfit(int[] prices) {
        int sum=0;
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i =0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            }
            else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
                sum+=maxprofit;
                minprice = Integer.MAX_VALUE;
                maxprofit = 0;
                i--;
            }
        }


        return sum;
    }

    public static int removeDuplicates4(int[] nums){
        int count=0;
        // 0,1,1,1,2,2,3,3,4
        // 0,1,1,1,2,2,3,3,4
        for (int i = 0; i <nums.length-1 ; i++) {
            if(nums[i]!=nums[i+1]){
                count++;
                nums[count] = nums[i+1];
            }
        }
        App.print(nums);
        return count+1;
    }


    public static int removeDuplicates3(int[] nums) {
        // [0,0,1,1,1,2,2,3,3,4]
        if(nums.length == 0)return 0;
        int flag = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[flag] != nums[i]){
                flag++;
                nums[flag] = nums[i];
            }
        }
        return flag+1;
    }

    public static int removeDuplicates2(int[] nums) {
        // [0,0,1,1,1,2,2,3,3,4]
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[count] != nums[i]) {
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }
    public static int removeDuplicates1(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int k = -1;
        int count = 1;
        // [0,1,2,3,4,2,2,3,3,4]
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] == nums[i + 1]){
                k++;
            }else {
                nums[i - k] = nums[i + 1];
                count++;
            }
        }
        return count;
    }


    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len==1){
            return 1;
        }else if(len==0){
            return 0;
        }
        // [0,0,1,1,1,2,2,3,3,4]         0,1,2,3,4,5,6,7,8
        for(int i=1;i<len;i++){
            if(nums[i]==nums[i-1]){
                for(int j=i-1;j<len-1;j++){
                    nums[j] = nums[j+1];
                }
                i--;
                len--;
            }
        }
        return len;
    }
    public static void out(){
        for (int i = 1; i <=100 ; i++) {
            if(jud(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean jud(int num){
        boolean flag = false;
        for (int i = 2; i <num ; i++) {
            for (int j = 2; j <num ; j++) {
                if(i*j==num){
                    return false;
                }
            }
        }
        return true;
    }

    public static double sqar(int num){
        double one = num/2.0+1;
        System.out.println(one);
        while(one*one-num>0.0001){
            if(one*one>num){
                one= one-0.1;
            }else{
                one= one+0.1;
            }
        }
        return one;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //[1,2,3,2,5,6]
        if(n==0){
            return;
        }
        int total = m+n-1;
        while(n>0){
            nums1[total]=nums2[n-1];
            total--;
            n--;
        }
        //1,2,3,2,5,6
        for(int i=1;i<nums1.length;i++){
            if(nums1[i]<nums1[i-1]){
                for(int j=0;j<i;j++){
                    if(nums1[i]<nums1[j]){
                        int temp = nums1[i];
                        nums1[i] = nums1[j];
                        nums1[j] = temp;
                        i--;
                    }
                }
            }
        }
    }
}
