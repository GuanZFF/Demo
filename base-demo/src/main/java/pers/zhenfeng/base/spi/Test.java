package pers.zhenfeng.base.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Grow-Worm
 * @date 2019/11/14
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ServiceLoader<SpiTest> load = ServiceLoader.load(SpiTest.class);
        Iterator<SpiTest> iterator = load.iterator();

        while (iterator.hasNext()) {
            SpiTest spiTest = iterator.next().getClass().newInstance();
            spiTest.test();
        }
    }

}
