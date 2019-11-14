package pers.zhenfeng.concurrent;

public class VolatileDemo {

    boolean stop = false;
//	volatile boolean stop = false;

    public static void main(String[] args) throws Exception {
        VolatileDemo v = new VolatileDemo();
        Thread ta = new Thread(v::execute);
        ta.start();
        Thread.sleep(2000);
        Thread tb = new Thread(v::shutdown);
        tb.start();
    }

    private void execute() {
        while (!stop) {
            String a = "a";
            System.out.println(a);
        }
    }

    private void shutdown() {
        System.out.println("do stop");
        stop = true;
    }


}