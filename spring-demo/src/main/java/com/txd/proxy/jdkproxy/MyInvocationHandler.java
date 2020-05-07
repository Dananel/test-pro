package com.txd.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 这个中写增强代码和将请求代理到真正的对象
 *
 * 代理对象把请求转发到handler（业务处理只能在这里写）
 *
 * handler转发请求到真实对象
 *
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 目标对象
     */
    private Object target;


    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行");
        method.invoke(target,args);
        return null;
    }
}
