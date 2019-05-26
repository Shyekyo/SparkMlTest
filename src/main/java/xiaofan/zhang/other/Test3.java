package xiaofan.zhang.other;


import sun.text.resources.sk.CollationData_sk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by zhangxiaofan on 2019/4/9.
 */
public class Test3 {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        ArrayList<String> list = new ArrayList<>();
        while(scanner.hasNext()){
            String next = scanner.next();
            if("end".equals(next)) break;
            list.add(next);
        }
//        for (String str:list) {
//            System.out.println(str);
//        }
        System.out.println("===============");
        int k = Integer.valueOf(list.get(0));
        list.remove(0);
        int n = Integer.valueOf(list.get(0));
        list.remove(0);
//        for (String str:list) {
//            System.out.println(str);
//        }
        ArrayList<Double> res = new ArrayList<>();
        for (int i = 0; i <list.size()-1 ; i++) {
            String[] s = list.get(i).split(" ");
            String[] s1 = list.get(i+1).split(" ");
            double cal = cal(Double.parseDouble(s[0]), Double.parseDouble(s[1]),
                    Double.parseDouble(s1[0]), Double.parseDouble(s1[1]));
            res.add(cal);
        }
        Collections.sort(res);
        double ceil = Math.ceil((n - 1) * (k / 100.0));
        System.out.println(ceil);
        Double aDouble = res.get((int) ceil);
        System.out.println(aDouble);
        //===========================================
        String str = "babcbabcbaccba";
        str = "bacab";
        String s = longestPalindrome1(str);
        System.out.println(s);
        int maxlong=0;
        String maxlongs="";
        for (int i = 0; i <str.length() ; i++) {
            for (int j = i+1; j <str.length() ; j++) {
                int len = j-i;
                String curr = str.substring(i,j+1);
                if(ok(curr)){
                    if(len>maxlong){
                        maxlong=len;
                        maxlongs=curr;
                    }
                }
            }
        }
        System.out.println(maxlongs);
        int target=9;
        int[] arrs ={1,2,3,4,5,6,7,8};
        int i = twoSearch(target, 0, arrs.length - 1, arrs);
        System.out.println(i);*/
    }
    private static double cal(double x1,double y1,double x2,double y2){
        double v = Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2);
        return Math.sqrt(v);
    }
    public static Boolean ok(String s){
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static String longestPalindrome1(String s) {
        int maxPalinLength = 0;
        String longestPalindrome = null;
        int length = s.length();

        // check all possible sub strings
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int len = j - i;
                String curr = s.substring(i, j + 1);
                if (isPalindrome(curr)) {
                    if (len > maxPalinLength) {
                        longestPalindrome = curr;
                        maxPalinLength = len;
                    }
                }
            }
        }

        return longestPalindrome;
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static int twoSearch(int target , int start ,int end , int[] arrs){
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(arrs[mid]>target){
            end = mid-1;
            return twoSearch(target,start,end,arrs);
        }else if(arrs[mid]<target){
            start = mid+1;
            return twoSearch(target,start,end,arrs);
        }else{
            return mid;
        }
    }
}
