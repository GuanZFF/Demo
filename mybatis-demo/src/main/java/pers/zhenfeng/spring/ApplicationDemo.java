package pers.zhenfeng.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.zhenfeng.mybatis.User;

import java.util.List;

/**
 * @author Grow-Worm
 * @date 2019/04/20
 */
public class ApplicationDemo {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserMapper mapper = applicationContext.getBean(UserMapper.class);
        List<User> users = mapper.getUsers();
        System.out.println("-------------------------------------------");
        users.forEach(item ->{
            System.out.println(item.getId() + " : " + item.getUsername() + " : " + item.getPassword());
            System.out.println("-------------------------------------------");
        });
    }

}
