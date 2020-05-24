package com.txd.Aop;

import org.springframework.stereotype.Component;

/**
 * aop待增强类
 */
@Component
public class Aop {
    public String test1(String name) {
        System.out.println("......test1.........");
        return "hello aop";
    }

    public void test2() {
        System.out.println("......test2.........");
    }
}
