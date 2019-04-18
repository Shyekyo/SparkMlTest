package xiaofan.zhang;

import com.github.nobodxbodon.zhconverter.简繁转换类;
import com.spreada.utils.chinese.ZHConverter;

/**
 * Created by zhangxiaofan on 2019/4/9.
 */
public class Test3 {

    public static void main(String[] args) {
        final 简繁转换类 繁体转换器 = 简繁转换类.取实例(简繁转换类.目标.繁体);
        final 简繁转换类 简体转换器 = 简繁转换类.取实例(简繁转换类.目标.简体);
        String s = 简体转换器.转换("簡單");
        System.out.println(s);
        String simplifiedStr = ZHConverter.convert("有背光的機械式鍵盤",ZHConverter.SIMPLIFIED);
        System.out.println(simplifiedStr);
        String simplifiedStr2 = ZHConverter.convert("有背光的机械式键盘",ZHConverter.TRADITIONAL);
        System.out.println(simplifiedStr2);
    }
}
