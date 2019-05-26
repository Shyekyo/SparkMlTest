package xiaofan.zhang.xiaofan.zhang.observerMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiaofan on 2019/5/26.
 */
public class Subject {
    private List<Observer> oblist = new ArrayList<>();
    private int state;

    public boolean add(Observer observer){
        return oblist.add(observer);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        updateAll();
    }

    private void updateAll() {
        for (Observer observer:oblist) {
            observer.update();
        }
    }
}
