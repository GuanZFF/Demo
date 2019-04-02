package pers.zhenfeng.spring.test;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Grow-Worm
 * @date 2019/03/30
 */
public class MyApplicationContext extends AnnotationConfigApplicationContext {

    public MyApplicationContext(Class<?>... annotatedClasses) {
        super(annotatedClasses);
    }


    @Override
    protected void initPropertySources() {

    }

    @Override
    protected void onRefresh() throws BeansException {
        super.onRefresh();
    }
}
