package com.txd.javaconfig;

import com.txd.config.MainConfig;
import com.txd.modle.Student;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * javaconfig配置测试
 */
public class TestConfig {

    @Test
    public void getStudent(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println(context.getBean("getStudent"));
    }
}
