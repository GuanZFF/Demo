package pers.zhenfeng.base;


/**
 * @author Grow-Worm
 * @date 2019/07/09
 */
public class SyncDemo {

    public native void runThread();

    public native int jniParam(int param);

    public native int getUserAge(User user);

    public void run() {
        System.out.println("SyncDemo.run");
    }

}
