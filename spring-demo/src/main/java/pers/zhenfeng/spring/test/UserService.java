package pers.zhenfeng.spring.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

/**
 * @author Grow-Worm
 * @date 2019/03/30
 */
@Component("userService-123")
public class UserService implements FactoryBean, BeanNameAware, BeanFactoryAware, MessageSourceAware {

    private BeanFactory beanFactory;

    public UserService() {
        System.out.println("UserService.Userservice");
    }

    @Override
    public Object getObject() throws Exception {
        OrderService orderService = new OrderService();
        orderService.setUsername("guanzhenfeng");
        return orderService;
    }

    @Override
    public Class<?> getObjectType() {
        return OrderService.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println(messageSource.getMessage("username", null, "", null));
        System.out.println(beanFactory.getBean(MessageSource.class).getMessage("password", null, "", null));
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("name = " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("UserService.setBeanFactory");
        this.beanFactory = beanFactory;
    }

}
