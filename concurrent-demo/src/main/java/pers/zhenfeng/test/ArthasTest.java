package pers.zhenfeng.test;

import java.io.IOException;

/**
 * @author Grow-Worm
 * @date 2019/03/17
 */
public class ArthasTest implements Runnable {

    public static void main(String[] args) throws IOException {

        ArthasTest arthasTest = new ArthasTest();

        new Thread(arthasTest, "ArthasTest Thread").start();

        System.in.read();
    }

    public String getUsername(String userId) {
        System.out.println("ArthasTest.getUsername");
        System.out.println("username = " + userId);
        return userId + "guanzhenfeng";
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.getUsername(String.valueOf(i));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
