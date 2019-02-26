package pers.zhenfeng.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.zhenfeng.spring.beans.User;

/**
 * @author Grow-Worm
 * @date 2019/02/27
 */
public class AnnotationApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        User bean = context.getBean(User.class);

        System.out.println(bean.getUsername());
        System.out.println(bean.getPassword());
    }

}
