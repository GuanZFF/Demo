package pers.zhenfeng.spring.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * jdk实现动态代理
 *
 * @author Grow-Worm
 * @date 2019/03/13
 */
public class JDKDynamicProxyDemo {

    public static void main(String[] args) throws Exception {
        // 开启动态生成的类进行存储
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Class<?> proxyClass = Proxy.getProxyClass(Thread.currentThread().getContextClassLoader(), UserServiceImpl.class.getInterfaces());

        UserService userService = (UserService) proxyClass.getConstructor(InvocationHandler.class).newInstance((InvocationHandler) (proxy, method, args1) -> {

            System.out.println("---------------------------------------");

            Object result = method.invoke(new UserServiceImpl(), args1);

            System.out.println("---------------------------------------");

            return result;
        });

        String username = userService.getUsername("123");

        System.out.println(username);
    }

}
