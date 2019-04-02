package pers.zhenfeng.spring.ioc;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author Grow-Worm
 * @date 2019/03/28
 */
@Configuration
@ComponentScan("pers.zhenfeng.spring.ioc")
public class MyConfig {

    @Bean(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME)
    public MessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("config");
        return resourceBundleMessageSource;
    }

}
