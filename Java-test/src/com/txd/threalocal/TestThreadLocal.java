package com.txd.threalocal;

public class TestThreadLocal {

    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("123");

        ThreadLocal<String> se = new ThreadLocal<>();
        se.set("456");


    }
}
