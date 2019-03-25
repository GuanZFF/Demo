package pers.zhenfeng.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author Grow-Worm
 * @date 2019/03/12
 */
public class ProviderDemo {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-provider.xml");
        context.start();

        System.in.read();
    }

}
