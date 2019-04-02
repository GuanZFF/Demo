package pers.zhenfeng.spring.ioc;

import org.springframework.context.MessageSource;

/**
 * @author Grow-Worm
 * @date 2019/03/28
 */
public class ApplicationDemo {

    public static void main(String[] args) {
        MyApplicationContext context = new MyApplicationContext(MyConfig.class);
        MessageSource messageSource = context.getBean(MessageSource.class);
        System.out.println(messageSource.getMessage("username", null, "", null));

    }

}
