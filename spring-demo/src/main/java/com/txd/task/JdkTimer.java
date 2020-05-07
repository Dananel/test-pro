package com.txd.task;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 测试jdk的定时任务
 */
public class JdkTimer extends TimerTask {

    @Override
    public void run() {
        System.out.println("jdk的定时任务，业务逻辑");
    }
}
