package pers.zhenfeng.dubbo.spi.impl;

import pers.zhenfeng.dubbo.spi.CarInterface;

/**
 * @author Grow-Worm
 * @date 2019/03/14
 */
public class RedCarInterface implements CarInterface {

    @Override
    public void getCarName(String id) {
        System.out.println("RedCarInterface.getCarName id = " + id);
    }

}
