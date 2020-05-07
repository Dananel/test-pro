package com.txd.proxy.jdkproxy;

import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args) {

        TargetObj targetObj = new TargetObj();

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(targetObj);

        Class<?>[] interfaces = targetObj.getClass().getInterfaces();

        IProxy proxy = (IProxy)Proxy.newProxyInstance(TestProxy.class.getClassLoader(),interfaces,myInvocationHandler);

        proxy.test();
    }
}
