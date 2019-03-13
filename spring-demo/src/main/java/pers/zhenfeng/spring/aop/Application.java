package pers.zhenfeng.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Grow-Worm
 * @date 2019/03/08
 */
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.index("guanzhenfeng");
        userService.printPassword();
        userService.printUsername();
    }

}
