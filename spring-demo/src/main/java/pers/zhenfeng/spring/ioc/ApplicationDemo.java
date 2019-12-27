package pers.zhenfeng.spring.ioc;

import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * @author Grow-Worm
 * @date 2019/03/28
 */
public class ApplicationDemo {

    public static void main(String[] args) {
        MyApplicationContext context = new MyApplicationContext(MyConfig.class);
        MessageSource messageSource = context.getBean(MessageSource.class);
        System.out.println(messageSource.getMessage("username", null, "", Locale.SIMPLIFIED_CHINESE));
        System.out.println(messageSource.getMessage("username", null, "", Locale.US));

        String username = messageSource.getMessage("username", null, "", Locale.US);

        System.out.println(messageSource.getMessage("welcome", new Object[]{username}, "", Locale.US));

        String username1 = messageSource.getMessage("username", null, "", Locale.SIMPLIFIED_CHINESE);

        System.out.println(messageSource.getMessage("welcome", new Object[]{username1}, "", Locale.SIMPLIFIED_CHINESE));

    }

}
