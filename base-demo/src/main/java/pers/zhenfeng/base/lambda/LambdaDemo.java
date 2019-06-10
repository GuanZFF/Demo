package pers.zhenfeng.base.lambda;

import java.io.IOException;

/**
 * @author Grow-Worm
 * @date 2019/05/16
 */
public class LambdaDemo {

    public static void main(String[] args) throws IOException {
        Runnable f = () -> System.out.println("LambdaDemo.main");
        f.run();

        MyFunction<String, String> mf = (String t) -> "r = " + t;
    }

}
