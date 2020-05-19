package com.txd.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试线程池
 */
public class TestExecutors {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        executorService.execute(() -> {
            System.out.println("sss");
        });

        executorService.shutdown();

        // 线程池调用shutdown之后，不能再提交任务：否则可能会有异常抛出，可能无反应（和拒绝策略有关）
        executorService.execute(() -> {
            System.out.println("close");
        });
    }
}
