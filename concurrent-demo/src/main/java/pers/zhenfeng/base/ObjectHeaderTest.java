package pers.zhenfeng.base;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author Grow-Worm
 * @date 2019/07/14
 */
public class ObjectHeaderTest {

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(5000);

        User user = new User();

//        System.out.println(Integer.toHexString(user.hashCode()));

        System.out.println(ClassLayout.parseInstance(user).toPrintable());
    }


}
