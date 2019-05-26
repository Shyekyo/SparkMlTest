package xiaofan.zhang.xiaofan.zhang.observerMode;

/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class BinObserver extends Observer{
    public BinObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println("2 : "+Integer.toBinaryString(this.subject.getState()));
    }
}
