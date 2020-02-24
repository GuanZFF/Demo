package pers.zhenfeng.base;

import java.math.BigDecimal;

/**
 * @author Grow-Worm
 * @date 2020/02/12
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(new BigDecimal(0.2).compareTo(BigDecimal.ZERO) > 0);

        System.out.println("123".hashCode());
    }

}
