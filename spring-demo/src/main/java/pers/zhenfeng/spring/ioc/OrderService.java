package pers.zhenfeng.spring.ioc;

import org.springframework.stereotype.Component;

/**
 * @author Grow-Worm
 * @date 2019/03/28
 */
@Component
public class OrderService {

    public void print() {
        System.out.println("OrderService.print");
    }

}
