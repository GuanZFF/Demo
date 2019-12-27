package pers.zhenfeng.web.config;

import java.util.Locale;

/**
 * @author Grow-Worm
 * @date 2019/12/19
 */
public class ThreadLocalUtil {

    private static ThreadLocal<Locale> threadLocal = new ThreadLocal<>();

    public static void setLocale(Locale locale) {
        threadLocal.set(locale);
    }

    public static Locale getLocale() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }

}
