package xiaofan.zhang;


/**
 * Created by zhangxiaofan on 2019/4/9.
 */
public class Test3 {
    public static void main(String[] args) {
        /*String str = "babcbabcbaccba";
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
        System.out.println(maxlongs);*/
        int target=9;
        int[] arrs ={1,2,3,4,5,6,7,8};
        int i = twoSearch(target, 0, arrs.length - 1, arrs);
        System.out.println(i);
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
