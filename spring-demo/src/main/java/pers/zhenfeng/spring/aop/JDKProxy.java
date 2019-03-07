package pers.zhenfeng.spring.aop;

import java.lang.reflect.Proxy;

/**
 * @author Grow-Worm
 * @date 2019/03/06
 */
public class JDKProxy {

    public static void main(String[] args) {
        UserService userService = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), new Class[]{UserService.class}, (proxy, method, args1) -> {
            System.out.println("before invoke...");
            method.invoke(new JDKProxy().new UserServiceImpl(), args1);
            System.out.println("after invoke...");
            return null;
        });

        userService.getUsername("123");
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
