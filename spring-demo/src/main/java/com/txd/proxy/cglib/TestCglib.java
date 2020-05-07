package com.txd.proxy.cglib;

public class TestCglib {

    public void test(){
        System.out.println("目标执行");
    }

    public static void main(String[] args) {
        TestCglib testCglib = new TestCglib();
        MyInterceptor myInterceptor = new MyInterceptor();
        TestCglib instatnce = (TestCglib)myInterceptor.getInstatnce(testCglib);
        instatnce.test();


    }
}
