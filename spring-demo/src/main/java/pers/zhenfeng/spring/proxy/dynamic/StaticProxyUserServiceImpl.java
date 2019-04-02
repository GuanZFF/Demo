package pers.zhenfeng.spring.proxy.dynamic;

/**
 * @author Grow-Worm
 * @date 2019/03/30
 */
public class StaticProxyUserServiceImpl extends UserServiceImpl {

    @Override
    public String getUsername(String userId) {
        System.out.println("StaticProxyUserServiceImpl.getUsername");
        return super.getUsername(userId);
    }

}
