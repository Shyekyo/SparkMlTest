package xiaofan.zhang.demo;

import xiaofan.zhang.other.App;

/**
 * Created by zhangxiaofan on 2019/6/3.
 */
public class demo2 {
    public static void main(String[] args) {
        demo2 demo2 = new demo2();
        int[] ints = {0,1,0};
        demo2.moveZeroes(ints);
        App.print(ints);
    }
    // 0 0 1
    public void moveZeroes(int[] nums) {
        int len=0;
        if(nums[nums.length-1]==0){
            len=len-1;
        }else{
            len = nums.length;
        }
        int count=0;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                count++;
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                for(int j=i+1;j<len;j++){
                    nums[j-1]=nums[j];
                }
                nums[nums.length-1]=0;
                count--;
                if(count==0){
                    break;
                }
                i--;
            }
        }
    }
}
