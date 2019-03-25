package pers.zhenfeng.aop;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Grow-Worm
 * @date 2019/03/25
 */
public class ZhenFengMethodInterceptor implements MethodInterceptor {

    private Object targetObject;

    ZhenFengMethodInterceptor(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(ZhenFeng.class)) {
                ZhenFeng zhenFeng = (ZhenFeng) annotation;
                if (!StringUtils.isEmpty(zhenFeng.before()))
                    System.out.println("-----------------" + zhenFeng.before() + "----------------");
                Object result = method.invoke(targetObject, params);
                if (!StringUtils.isEmpty(zhenFeng.after()))
                    System.out.println("-----------------" + zhenFeng.after() + "----------------");
                return result;
            }
        }

        return method.invoke(targetObject, params);
    }
}
