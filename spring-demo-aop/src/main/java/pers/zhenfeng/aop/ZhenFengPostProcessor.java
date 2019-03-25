package pers.zhenfeng.aop;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Grow-Worm
 * @date 2019/03/25
 */
@Component
public class ZhenFengPostProcessor implements InstantiationAwareBeanPostProcessor {

    private Map<String, Object> mapProxy = Maps.newHashMap();

    private Object getProxy(Class<?> beanClass, String beanName) {
        Object proxy = mapProxy.get(beanName);
        if (ObjectUtils.isEmpty(proxy)) {
            try {
                mapProxy.put(beanName, Enhancer.create(beanClass, new ZhenFengMethodInterceptor(beanClass.newInstance())));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return mapProxy.get(beanName);
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return Stream.of(beanClass.getDeclaredMethods())
            .filter(item -> Stream.of(item.getDeclaredAnnotations()).anyMatch(item1 -> item1.annotationType().equals(ZhenFeng.class)))
            .map(item -> getProxy(beanClass, beanName))
            .findFirst().orElse(null);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }
}
