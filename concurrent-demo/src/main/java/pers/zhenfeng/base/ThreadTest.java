package pers.zhenfeng.base;


import java.io.IOException;

/**
 * @author Grow-Worm
 * @date 2019/07/11
 */
public class ThreadTest {

    public static void main(String[] args) throws IOException {
        int a = 0;
        int b = 1;

        int c = a + b;

        int read = System.in.read();

        new ThreadTest().hashCode();

        System.out.println(read);
    }

}
