package pers.zhenfeng.dubbo.spi.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import pers.zhenfeng.dubbo.spi.CarInterface;

/**
 * @author Grow-Worm
 * @date 2019/03/14
 */
public class DubboCarSpiDemo {

    public static void main(String[] args) {
        ExtensionLoader<CarInterface> extensionLoader = ExtensionLoader.getExtensionLoader(CarInterface.class);

        CarInterface carInterface = extensionLoader.getExtension("a");

        carInterface.getCarName("123");

    }

}
