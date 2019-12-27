package pers.zhenfeng.web.config;

import org.springframework.context.MessageSource;

/**
 * @author Grow-Worm
 * @date 2019/12/19
 */
public class MessageUtil {

    private static MessageSource messageSource = BeanUtil.getBean(MessageSource.class);

    public static String getMessage(String key) {
        return messageSource.getMessage(key, null, null, ThreadLocalUtil.getLocale());
    }
}
