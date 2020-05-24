package com.txd.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * spring注解式配置
 */
@Component
@Aspect
public class TestAop {

    @Pointcut("execution(public * com.txd.Aop.Aop.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println(".....before......");
    }

    @After(value = "pointCut()")
    public void after() {
        System.out.println(".....after......");
    }

    /**
     * 拿到返回值
     *
     * @param result 返回值
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturn(String result) {
        System.out.println(".....afterReturn......");
    }

    /**
     * 拿到异常信息
     *
     * @param exception 异常信息
     */
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void exception(Exception exception) {
        System.out.println(".....exception......");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println(".....around before......");
        Object[] args = proceedingJoinPoint.getArgs();
        proceedingJoinPoint.proceed(args);
        System.out.println(".....around after......");
    }
}
