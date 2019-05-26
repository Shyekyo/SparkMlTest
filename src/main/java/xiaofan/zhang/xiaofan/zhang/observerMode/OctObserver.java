package xiaofan.zhang.xiaofan.zhang.observerMode;

/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class OctObserver extends Observer{

    public OctObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println("8 : "+Integer.toOctalString(this.subject.getState()));
    }
}
