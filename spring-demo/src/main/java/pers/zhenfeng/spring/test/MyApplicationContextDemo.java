package pers.zhenfeng.spring.test;

/**
 * @author Grow-Worm
 * @date 2019/03/30
 */
public class MyApplicationContextDemo {

    public static void main(String[] args) throws Exception {
        MyApplicationContext context = new MyApplicationContext(MyApplicationConfiguration.class);
        context.getBean(OrderService.class);
        context.getBean(OrderService.class);

        context.close();
    }

}
