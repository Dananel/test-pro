package com.txd.testjuc.juc;

import com.txd.juc.BlockQueueTest;
import org.junit.Test;

import java.util.concurrent.*;

public class BlockQueuetest {

    @Test
    public void testBolockQueueInterrupt() throws InterruptedException {
        BlockQueueTest.testBolockQueueInterrupt();
    }

    @Test
    public void testNewCachedThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        });

        // 阻塞
       // String ss = future.get();

        //System.out.println(ss);

    }

    @Test
    public  void test() throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>(true);
        new Thread(()->{
            try {
                queue.put("123");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(10000);

        new Thread(()->{
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }

    @Test
    public void testSynchronizedQueue() throws InterruptedException {
        // 如果一个线程生产的消息没被消费，这个线程就阻塞，直到被消费，才可以继续生产
        BlockQueueTest blockQueueTest = new BlockQueueTest();
        blockQueueTest.testSynchronizedQueue();
    }
}
