package pers.zhenfeng.spring.proxy.dynamic;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * cglib实现动态代理
 *
 * @author Grow-Worm
 * @date 2019/03/13
 */
public class CglibDynamicProxyDemo {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("---------------------------------------");

            Object result = method.invoke(new UserServiceImpl(), objects);

            System.out.println("---------------------------------------");

            return result;
        });

        enhancer.setSuperclass(UserServiceImpl.class);

        UserService userService = (UserService) enhancer.create();

        String username = userService.getUsername("123");

        System.out.println(username);
    }

}
