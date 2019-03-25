package pers.zhenfeng.aop;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Grow-Worm
 * @date 2019/03/25
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(ZhenFengConfig.class)
public @interface EnableZhenFeng {

}
