package pers.zhenfeng.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Grow-Worm
 * @date 2019/03/08
 */
@Configuration
@ComponentScan("pers.zhenfeng.spring.aop")
@EnableAspectJAutoProxy
public class AppConfig {
}
