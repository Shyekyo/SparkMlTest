package xiaofan.zhang.demo;

/**
 * Created by zhangxiaofan on 2019/6/9.
 */
public class demo12 {
    public static void main(String[] args) {
        demo12 demo12 = new demo12();
        String str = "-91283472332";
        str ="4193 with words";
        int i = demo12.myAtoi(str);
        System.out.println(i);
    }
    public int myAtoi(String str) {
        while(str.startsWith(" ")||str.startsWith("0")){
            str = str.substring(1);
        }
        Boolean falg =false;
        StringBuffer sb = new StringBuffer(30);
        if(str.startsWith("-")){
            sb.append(str.charAt(0));
            falg =true;
        }
        int j=0;
        if(falg){
            j=1;
        }
        for (int i =j;i <str.length() ; i++) {
            if(('0'>(str.charAt(j)) || '9'<(str.charAt(j)))){
                return 0;
            }
            else if(('0'<(str.charAt(i)) && '9'>=(str.charAt(i)))){
                sb.append(str.charAt(i));
            }
        }
        Integer integer=0;
        try{
            integer = Integer.valueOf(sb.toString());
        }catch (Exception e){
            if(falg){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        return integer.intValue();
    }
}
