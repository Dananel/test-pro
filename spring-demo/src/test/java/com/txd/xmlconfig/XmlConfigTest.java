package com.txd.xmlconfig;

import com.txd.model.Student;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试spring的xml配置方式
 */
public class XmlConfigTest {

    /**
     * spring的ioc环境
     */
    private static  ClassPathXmlApplicationContext context = null;

    @Test
    public void init() {
        context = new ClassPathXmlApplicationContext("application.xml");
        Student student = (Student)context.getBean("student");
        System.out.println(student);
    }
}
