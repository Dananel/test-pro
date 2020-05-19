package com.txd.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class ExecutorTest {

    /**
     * 使用Executors创建单线程的线程池
     */
    public void testExecutore(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            System.out.println("test Executors.newSingleThreadExecutor()");
        });

        executorService.shutdown();
    }

    /**
     * 使用Executors创建固定线程数量的线程池
     */
    public void testExecutoreFixedThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        executorService.execute(()->{
            System.out.println("test Executors.newFixedThreadPool()");
        });

        executorService.shutdown();
    }

    /**
     * 使用Executors创建动态线程数的线程池：能创多少就创多少
     */
    public void testExecutoreCachedThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            System.out.println("test Executors.newCachedThreadPool()");
        });

        executorService.shutdown();
    }
}
