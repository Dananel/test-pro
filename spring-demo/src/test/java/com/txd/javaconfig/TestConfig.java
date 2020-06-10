package com.txd.javaconfig;

import com.txd.config.MainConfig;
import com.txd.modle.Student;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * javaconfig配置测试
 */
public class TestConfig {
    private static AnnotationConfigApplicationContext context;

    @BeforeClass
    public static  void init(){
        context  = new AnnotationConfigApplicationContext(MainConfig.class);
    }

    @Test
    public void getAllBeanNames(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
    }

    @Test
    public void getStudent(){
        System.out.println(context.getBean("getStudent"));
    }

    @Test
    public void testPropertyResouse(){
        System.out.println(context.getBean("testproperties"));

    }
}
