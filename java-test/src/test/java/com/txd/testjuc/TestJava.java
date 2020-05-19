package com.txd.testjuc;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试
 */
public class TestJava {

    @Test
    public void test1() {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println(atomicInteger);
    }

    @Test
    public void testThreadInterrupt(){
        Thread thread = Thread.currentThread();
        thread.interrupt();

        System.out.println(thread.isInterrupted());
    }
}
