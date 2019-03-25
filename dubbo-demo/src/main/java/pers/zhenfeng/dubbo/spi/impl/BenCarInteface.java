package pers.zhenfeng.dubbo.spi.impl;

import pers.zhenfeng.dubbo.spi.CarInterface;

/**
 * @author Grow-Worm
 * @date 2019/03/15
 */
public class BenCarInteface implements CarInterface {

    private CarInterface carInterface;

    public BenCarInteface(CarInterface carInterface) {
        this.carInterface = carInterface;
    }

    @Override
    public void getCarName(String id) {
        System.out.println("BenCarInteface.getCarName id = " + id);
        carInterface.getCarName(id);
    }

}
