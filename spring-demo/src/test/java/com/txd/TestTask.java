package com.txd;

import com.txd.task.JdkTimer;
import org.junit.Test;

import java.util.Timer;

/**
 * 测试定时任务
 */
public class TestTask {

    /*
    *
    * 1： 终止timer的方式
1》调用timer的cancle方法，
2》把timer线程设置成daemon线程，（new Timer(true)创建daemon线程），在jvm里，如果所有用户线程结束，那么守护线程也会被终止，不过这种方法一般不用。
3》当所有任务执行结束后，删除对应timer对象的引用，线程也会被终止。
4》调用System.exit方法终止程序

2：注意点

1》每一个Timer仅对应唯一一个线程。
2》Timer不保证任务执行的十分精确， schedule如果某一次调度时间比较长，那么后面的时间会顺延和scheduleAtFixedRate(严格按照调度时间来的，如果某次调度时间太长了，那么会通过缩短间隔的方式保证下一次调度在预定时间执行)会有不同的时间差。
Timer类的线程安全的
3》jdk1.5之后，ScheduledExecutorService代替了Timer来实现任务调度，加入了线程池等特性
     */
    @Test
    public void testJdkTimer() {
        Timer timer = new Timer();
        timer.schedule(new JdkTimer(), 1);

        try {
            // 需要先等一会，防止定时任务还没启动，主线程就结束了
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
