package xiaofan.zhang.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangxiaofan on 2019/6/8.
 */
public class demo10 {
    public static void main(String[] args) {
        demo10 demo10 = new demo10();
    }

    public boolean isPalindrome1(String s) {
        char[] cha = s.toCharArray();
        int i = 0, j = cha.length - 1;
        while(i < j){
            if(!Character.isLetterOrDigit(cha[i]))
                i++;
            else if(!Character.isLetterOrDigit(cha[j]))
                j--;
            else
            if(Character.toLowerCase(cha[i]) == Character.toLowerCase(cha[j])){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-z|A-Z|0-9]", "");
        s = s.replaceAll(" ","");
        s = s.toLowerCase();
        if(s.length()==0) return false;
        System.out.println(s);
        char[] chars = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(chars[i]!=chars[s.length()-1-i]){
                System.out.println(chars[i] +"   "+chars[s.length()-1-i]);
                return false;
            }
        }
        return true;
    }
}
