package pers.zhenfeng.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.zhenfeng.dubbo.api.UserService;

/**
 * @author Grow-Worm
 * @date 2019/03/12
 */
public class ConsumerDemo {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
        UserService userService = (UserService) context.getBean("userService");

        for (int i = 0; i <100; i++) {
            System.out.println(userService.sayHello());
            Thread.sleep(2000);
        }
    }

}
