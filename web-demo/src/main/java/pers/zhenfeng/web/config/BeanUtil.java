package pers.zhenfeng.web.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @author Grow-Worm
 * @date 2019/12/19
 */
@Component
public class BeanUtil implements BeanFactoryAware {

    private static BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        BeanUtil.beanFactory = beanFactory;
    }

    public static <T> T getBean(Class<T> t) {
        return BeanUtil.beanFactory.getBean(t);
    }

}
