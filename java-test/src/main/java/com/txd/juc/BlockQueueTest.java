package com.txd.juc;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列测试
 */
public class BlockQueueTest {

    /**
     * 测试线程打断的情况下，调用阻塞队列的poll是否有异常抛出: 发现有异常抛出
     */
    public static void testBolockQueueInterrupt() throws InterruptedException {
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(100);
        strings.put("123");
        strings.put("sd");
        strings.put("gr");
        Thread.currentThread().interrupt();

        System.out.println(strings.take());
    }
}
