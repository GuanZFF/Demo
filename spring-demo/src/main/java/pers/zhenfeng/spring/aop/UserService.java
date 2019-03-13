package pers.zhenfeng.spring.aop;

import org.springframework.stereotype.Service;

/**
 * @author Grow-Worm
 * @date 2019/03/08
 */
@Service
public class UserService {

    public void index(String username) {
        System.out.println(username);
        System.out.println("UserService.index");
    }

    public void printUsername() {
        System.out.println("UserService.printUsername");
    }

    public void printPassword() {
        System.out.println("UserService.printPassword");
    }

}
