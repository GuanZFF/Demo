package pers.zhenfeng.dubbo.spi.impl;

import pers.zhenfeng.dubbo.spi.CarInterface;

/**
 * @author Grow-Worm
 * @date 2019/03/14
 */
public class BlackCarInterface implements CarInterface {

    @Override
    public void getCarName(String id) {
        System.out.println("BlackCarInterface.getCarName id = " + id);
    }

}
