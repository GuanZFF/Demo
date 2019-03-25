package pers.zhenfeng.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pers.zhenfeng.aop.EnableZhenFeng;

/**
 * @author Grow-Worm
 * @date 2019/03/08
 */
@Configuration
@ComponentScan("pers.zhenfeng.spring.aop")
@EnableAspectJAutoProxy
@EnableZhenFeng
public class AppConfig {
}
