package pers.zhenfeng.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.zhenfeng.mybatis.User;

import java.util.List;

/**
 * @author Grow-Worm
 * @date 2019/04/20
 */
public class ApplicationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserMapper bean = applicationContext.getBean(UserMapper.class);
        List<User> users = bean.getUsers();
        System.out.println(users);
    }

}
