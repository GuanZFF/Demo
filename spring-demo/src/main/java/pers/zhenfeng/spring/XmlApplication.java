package pers.zhenfeng.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.zhenfeng.spring.beans.DataSources;
import pers.zhenfeng.spring.beans.User;

/**
 * spring bean的相关配置
 *
 * @author Grow-Worm
 * @date 2019/02/27
 */
public class XmlApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        User bean = context.getBean(User.class);

        System.out.println(bean.getPassword());
        System.out.println(bean.getUsername());
        System.out.println(bean.getTrans());

        DataSources bean1 = context.getBean(DataSources.class);

        System.out.println(bean1.getUrl());
    }

}
