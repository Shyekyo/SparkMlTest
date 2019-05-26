package xiaofan.zhang;

import org.apache.commons.collections.map.HashedMap;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by zhangxiaofan on 2019/5/25.
 */
public class StringParrten {

    public static void main(String[] args) {
        String str = "{{}}{{}}<<>><<>>(())(())[[]][[]]";
        str = "<{}>";
        boolean partten = partten(str);
        System.out.println(partten);
    }

    public static boolean partten(String str){
        HashMap<Character, Character> chmap = new HashMap<>();
        chmap.put('}','{');
        chmap.put('>','<');
        chmap.put(')','(');
        chmap.put(']','[');
        HashMap<Character, Integer> chnum = new HashMap<>();
        chnum.put('{',4);
        chnum.put('[',3);
        chnum.put('(',2);
        chnum.put('<',1);
        Stack<Character> stack = new Stack();
        Stack stack1 = new Stack();
        //"    {<{}>}}{{}}<<>><<>>(())(())[[]][[]]   "
        for (int i = 0; i <str.length() ; i++) {
            Character c = str.charAt(i);
            if(chmap.containsValue(c)){
                if(!stack.isEmpty()){
                    Character peek = stack.peek();
                    if(chnum.get(peek)<chnum.get(c)){
                        return false;
                    }
                }
                stack.push(c);
            }else if(chmap.containsKey(c)){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek()==chmap.get(c)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty()?true:false;
    }
    public static void print(Stack stack){
        System.out.println(stack.pop());
    }
}
