package com.txd.juc;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;

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
    
    public void testSynchronizedQueue() throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("线程1========put=="+1);
                queue.put("1");
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("线程2========put=="+2);
                queue.put("2");
            }
        }).start();

        Thread.sleep(10000000);
    }
}
