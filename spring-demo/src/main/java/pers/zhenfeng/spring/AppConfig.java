package pers.zhenfeng.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pers.zhenfeng.spring.beans.User;

/**
 * @author Grow-Worm
 * @date 2019/02/27
 */
@Configuration
@ComponentScan("pers.zhenfeng.spring")
public class AppConfig {

    @Bean
    public User getUser() {
        return new User("guanzf", "123456");
    }

}
