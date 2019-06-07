package xiaofan.zhang.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhangxiaofan on 2019/6/6.
 */
public class demo6 {
    public static void main(String[] args) {
        demo6 demo6 = new demo6();
        String s = "leetcode";
        int i = demo6.firstUniqChar(s);
    }
    public int firstUniqChar1(String s) {
        int min = s.length();
        for (char i = 'a'; i <='z' ; i++) {
            int left = s.indexOf(i);
            int right = s.lastIndexOf(i);
            if(left != -1 && left==right && min>left)
                min = left;
        }
        if(min == s.length()) return -1;
        else return min;
    }

    public int firstUniqChar(String s) {
        Map<Character,String> map =new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==null)
            {
                map.put(s.charAt(i),1+"_"+i);
            }else{
                String[] strs = map.get(s.charAt(i)).split("_");
                int count = Integer.valueOf(strs[0])+1;
                if(count>=3) continue;
                map.put(s.charAt(i),count+"_"+strs[1]);
            }
        }
        for(Map.Entry<Character,String> entry :map.entrySet()){
            // System.out.println(map.get(c));
            if(entry.getValue().split("_")[0].equals("1")){
                return Integer.valueOf(entry.getValue().split("_")[1]);
            }
        }
        return -1;
    }
}
