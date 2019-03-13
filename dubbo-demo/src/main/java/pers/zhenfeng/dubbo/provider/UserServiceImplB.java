package pers.zhenfeng.dubbo.provider;

import pers.zhenfeng.dubbo.api.UserService;

/**
 * @author Grow-Worm
 * @date 2019/03/12
 */
public class UserServiceImplB implements UserService {

    @Override
    public String sayHello() {
        return "hello B";
    }

}
