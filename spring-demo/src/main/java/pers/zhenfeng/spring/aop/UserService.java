package pers.zhenfeng.spring.aop;

import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Service;
import pers.zhenfeng.aop.ZhenFeng;

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

    @ZhenFeng(before = "before", after = "after")
    public void printUsername() {
        System.out.println("UserService.printUsername");
    }

    @ZhenFeng(before = "printPassword")
    public void printPassword() {
        System.out.println("UserService.printPassword");
    }

}
