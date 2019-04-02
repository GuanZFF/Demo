package pers.zhenfeng.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Grow-Worm
 * @date 2019/03/28
 */
public class MyApplicationContext extends AnnotationConfigApplicationContext {

    public MyApplicationContext(Class<?>... annotatedClasses) {
        super(annotatedClasses);
    }

    @Override
    protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        System.out.println("MyApplicationContext.postProcessBeanFactory");
    }

    @Override
    protected void onRefresh() throws BeansException {
        System.out.println("MyApplicationContext.onRefresh");
    }
}
