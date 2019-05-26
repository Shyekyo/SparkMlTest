package xiaofan.zhang.xiaofan.zhang.observerMode;

/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class HexObserver extends Observer{

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println("16 : "+Integer.toHexString(this.subject.getState()));
    }
}
