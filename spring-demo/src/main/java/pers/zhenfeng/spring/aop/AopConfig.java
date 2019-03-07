package pers.zhenfeng.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Grow-Worm
 * @date 2019/03/08
 */
@Component
@Aspect
public class AopConfig {

    @Pointcut("execution(* index(..)) || execution(* print*())")
    public void pointCut() {}


    @Before("pointCut()")
    public void beforeAdvice() {
        System.out.println("AopConfig.beforeAdvice");
    }


}
