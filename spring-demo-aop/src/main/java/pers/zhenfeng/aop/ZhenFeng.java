package pers.zhenfeng.aop;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ZhenFeng {

    String before() default "";

    String after() default "";

}
