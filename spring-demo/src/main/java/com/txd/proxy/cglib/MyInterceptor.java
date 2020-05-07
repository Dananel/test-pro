package com.txd.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyInterceptor implements MethodInterceptor {
    /**
     * 目标对象
     */
    private Object target;

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {

        System.out.println("代理执行");

        proxy.invokeSuper(object,objects);

        return null;
    }

    public Object getInstatnce(Object target){
        this.target = target;

        // 生成代理类
        Enhancer enhancer = new Enhancer();

        // 需要继承的父类
        enhancer.setSuperclass(this.target.getClass());

        // 代理对象通过这个引用转发请求到拦截器
        enhancer.setCallback(this);

        return enhancer.create();
    }
}
