package pers.zhenfeng.spring.test;

/**
 * @author Grow-Worm
 * @date 2019/03/30
 */
public class OrderService {

    public OrderService() {
        System.out.println("OrderService.OrderService");
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
