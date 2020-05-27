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
    public  void test(){
        SynchronousQueue<String> queue = new SynchronousQueue<>(true);
        queue.offer("123");

        queue.offer("123");
        queue.offer("123");

        queue.offer("123");
        queue.offer("123");

        queue.offer("123");


    }
}
