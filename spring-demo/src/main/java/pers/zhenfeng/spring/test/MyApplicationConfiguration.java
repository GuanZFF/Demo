package pers.zhenfeng.spring.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author Grow-Worm
 * @date 2019/03/30
 */
@Configuration
@ComponentScan("pers.zhenfeng.spring.test")
public class MyApplicationConfiguration {

    @Bean("messageSource")
    public ResourceBundleMessageSource getMessageSourceBean() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("config");
        return messageSource;
    }

}
