package pers.zhenfeng.spring.proxy.dynamic;

/**
 * @author Grow-Worm
 * @date 2019/03/13
 */
public class UserServiceImpl implements UserService {

    @Override
    public String getUsername(String userId) {
        System.out.println("UserServiceImpl.getUsername");
        return "dynamic proxy";
    }

}
