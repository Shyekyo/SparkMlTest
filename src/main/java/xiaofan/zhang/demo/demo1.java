package xiaofan.zhang.demo;

import xiaofan.zhang.other.App;

import java.util.*;

/**
 * Created by zhangxiaofan on 2019/6/3.
 */
public class demo1 {

    public static void main(String[] args) {
        demo1 demo1 = new demo1();
        int[] ints = {4,9,5};
        int[] ints1 = {9,4,9,8,4};
        int i =0;
        if(++i>0){
            System.out.println("--");
        }
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <nums1.length ; i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for (int j = 0; j <nums2.length ; j++) {
            if(map.containsKey(nums2[j])){
                if(map.get(nums2[j])>0){
                    list.add(nums2[j]);
                    map.put(nums2[j],map.get(nums2[j])-1);
                }
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            ints[i]=list.get(i);
        }
        return ints;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        int [] ans = new int [nums2.length];
        int index = 0;
        while(i++ < nums1.length && j++ < nums2.length){
            if(nums1[i - 1] == nums2[j - 1])
                ans[index++] = nums1[i - 1];
            else if(nums1[i - 1] < nums2[j - 1])
                j--;
            else
                i--;
        }
        return Arrays.copyOf(ans, index);
    }
}
