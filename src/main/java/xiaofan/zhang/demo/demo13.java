package xiaofan.zhang.demo;

/**
 * Created by zhangxiaofan on 2019/6/9.
 */
public class demo13 {
    public static void main(String[] args) {
        demo13 demo13 = new demo13();
        String haystack="mississippi";
        String needle="issip";
        int i = demo13.strStr2(haystack, needle);
        System.out.println(i);
    }

    public int strStr1(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        if (haystack.length() == 0 || needle.length() > haystack.length()) {
            return -1;
        }

        char hr[] = haystack.toCharArray();
        char nr[] = needle.toCharArray();

        for (int i = 0; i < hr.length; i++) {
            if (hr.length - i < nr.length) {
                return -1;
            }

            boolean find = true;
            for (int j = 0; j < nr.length; j++) {
                if (hr[i + j] != nr[j]) {
                    find = false;
                    break;
                }
            }

            if (find) {
                return i;
            }
        }

        return -1;
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        for (int i = 0; i <haystack.length() ; i++) {
            int neindex=0;
            if(haystack.charAt(i)==needle.charAt(0)){
                int count = 0;
                int index =i;
                for (int j = i; j <haystack.length() ; j++) {
                    if(haystack.charAt(j) == needle.charAt(neindex)){
                        count++;
                        neindex++;
                        if(neindex==needle.length()){
                            return index;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                //System.out.println(i +"----" +j);
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    //System.out.println("i+j   "+(i+j)+"    "+j);
                    flag =false;
                    break;
                }
            }
            if(flag){
                return i;
            }
            //System.out.println("===========");
        }
        return -1;
    }
}
