package pers.zhenfeng.web.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pers.zhenfeng.web.mapper.User;
import pers.zhenfeng.web.mapper.UserMapper;
import sun.misc.Signal;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Grow-Worm
 * @date 2020/02/24
 */
@Component
public class SignalBean implements InitializingBean {

    @Resource
    private UserMapper userMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Signal.handle(new Signal("USR2"), signal -> {

            long time = System.currentTimeMillis() + 20000;

            while (System.currentTimeMillis() < time) {
                User user = new User();
                user.setUsername(UUID.randomUUID().toString());
                user.setPassword(UUID.randomUUID().toString());

                userMapper.insertUser(user);
            }

        });
    }


}
