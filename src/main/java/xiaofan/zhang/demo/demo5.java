package xiaofan.zhang.demo;

import xiaofan.zhang.other.App;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by zhangxiaofan on 2019/6/6.
 */
public class demo5 {
    public static void main(String[] args) {
        demo5 demo5 = new demo5();
        int a = 1534236469;
        int b = 2147483647;
        a = -120;
        int maxValue = Integer.MAX_VALUE;
        int reverse = demo5.reverse(a);
        System.out.println(reverse);
        String s="sd";
        
    }

    public int reverse1(int x) {
        long result=0;
        do{
            result=result*10+x%10;
            x=x/10;
        }while(x!=0);
        if(result<Integer.MIN_VALUE ||result>Integer.MAX_VALUE){
            return 0;
        }
        return (int)result;
    }

    public int reverse(int x) {
        while(x%10==0){
            x=x/10;
        }
        if(Integer.MAX_VALUE>=x&&Integer.MIN_VALUE<=x){
            String res = String.valueOf(x);
            char[] s = res.toCharArray();
            if(x+0>0){
                int sb = reverseString(s,true);
                return sb;
            }else if(x+0<0){
                int sb2 =reverseString(s,false);
                return sb2;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    public int reverseString(char[] s,Boolean falg) {
        StringBuffer sb = new StringBuffer(11);
        if(falg){
            for(int i=0;i<(s.length)/2;i++){
                if(s[i]!=s[s.length-1-i]){
                    char tmp = s[i];
                    s[i]=s[s.length-1-i];
                    s[s.length-1-i]=tmp;
                }
            }
            for(int i=0;i<s.length;i++){
                System.out.println(s[i]);
                sb.append(s[i]);
            }
        }else{
            for(int i=1;i<=(s.length)/2;i++){
                if(s[i]!=s[s.length-i]){
                    char tmp = s[i];
                    s[i]=s[s.length-i];
                    s[s.length-i]=tmp;
                }
                for(int j=0;j<s.length;j++){
                    System.out.print(s[j]);
                }
            }

            for(int i=0;i<s.length;i++){
                sb.append(s[i]);
            }
        }
        Integer integer = null;
        try {
            integer = Integer.valueOf(sb.toString());
        }catch (Exception e){
        } finally {

        }
        return integer;
    }
}
