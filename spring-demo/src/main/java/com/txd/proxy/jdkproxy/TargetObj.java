package com.txd.proxy.jdkproxy;

public class TargetObj implements IProxy {
    @Override
    public void test() {
        System.out.println("真实对象执行了");
    }
}
