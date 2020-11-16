package pers.zhenfeng.base.vavr;


import io.vavr.control.Option;

/**
 * @author Grow-Worm
 * @date 2020/08/17
 */
public class VAVRJava {

    public static void main(String[] args) {
        System.out.println(Option.of("123").get());
    }

}
