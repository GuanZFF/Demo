package pers.zhenfeng.spring.proxy.dynamic;

/**
 * @author Grow-Worm
 * @date 2019/03/30
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        UserService userService = new StaticProxyUserServiceImpl();
        userService.getUsername("123");
    }

}
