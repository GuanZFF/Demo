package pers.zhenfeng.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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


    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object result = null;
        try {
            Object[] args = pjp.getArgs();
            System.out.println("AopConfig.aroundAdvice before");
            result = pjp.proceed(args);
            System.out.println("AopConfig.aroundAdvice after");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
