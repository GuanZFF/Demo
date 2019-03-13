package pers.zhenfeng.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Grow-Worm
 * @date 2019/03/06
 */
public class JDKProxy {

    public static void main(String[] args) throws Exception {

        // 实现方式一
        UserService userService = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), new Class[]{UserService.class}, (proxy, method, args1) -> {
            System.out.println("before invoke...");
            Object result = method.invoke(new JDKProxy().new UserServiceImpl(), args1);
            System.out.println("after invoke...");
            return result;
        });

        System.out.println(userService.getUsername("890"));

        // 实现方式二
        Class<?> proxyClass = Proxy.getProxyClass(UserServiceImpl.class.getClassLoader(), UserService.class);
        userService = (UserService) proxyClass.getConstructor(InvocationHandler.class).newInstance((InvocationHandler) (proxy, method, args12) -> {
            System.out.println("The second way implement before invoke...");
            Object result = method.invoke(new JDKProxy().new UserServiceImpl(), args12);
            System.out.println("The second way implement after invoke...");
            return result;
        });

        System.out.println(userService.getUsername("123"));

    }

    interface UserService {
        String getUsername(String userId);
    }

    class UserServiceImpl implements UserService {

        @Override
        public String getUsername(String userId) {
            System.out.println("userId = " + userId);
            System.out.println("UserServiceImpl.getUsername");
            return "username = guanzf";
        }

    }
}
