package xiaofan.zhang;


/**
 * Created by zhangxiaofan on 2019/4/9.
 */
public class Test3 {
    public static void main(String[] args) {
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
}
