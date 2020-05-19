package com.txd.testjuc.juc;

import com.txd.juc.ExecutorTest;
import org.junit.Test;

/**
 * 线程池测试
 */
public class TestThreadPool {

    @Test
    public void testSingleThreadExecutor(){
        ExecutorTest executorTest = new ExecutorTest();
        executorTest.testExecutore();
    }
}
