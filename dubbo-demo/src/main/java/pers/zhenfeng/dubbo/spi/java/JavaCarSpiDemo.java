package pers.zhenfeng.dubbo.spi.java;


import pers.zhenfeng.dubbo.spi.CarInterface;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Grow-Worm
 * @date 2019/03/14
 */
public class JavaCarSpiDemo {

    public static void main(String[] args) {
        ServiceLoader<CarInterface> serviceLoader = ServiceLoader.load(CarInterface.class);

        Iterator<CarInterface> iterator = serviceLoader.iterator();

        while (iterator.hasNext()) {
            CarInterface carInterface = iterator.next();
            carInterface.getCarName("123");
        }
    }

}
