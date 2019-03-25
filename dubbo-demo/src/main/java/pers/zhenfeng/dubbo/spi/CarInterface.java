package pers.zhenfeng.dubbo.spi;


import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author Grow-Worm
 * @date 2019/03/14
 */
@SPI
public interface CarInterface {

    void getCarName(String id);

}
