package pers.zhenfeng.web.config;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import sun.misc.Signal;

/**
 * @author Grow-Worm
 * @date 2020/02/24
 */
@Component
public class SignalBean implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {

        Signal.handle(new Signal("USR2"), signal -> {

            System.out.println(JSON.toJSONString(signal));

        });
    }


}
