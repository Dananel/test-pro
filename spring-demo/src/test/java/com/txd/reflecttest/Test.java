package com.txd.reflecttest;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 测试反射技术
 */
public class Test {

    @org.junit.Test
    public void testGetMethod() throws ClassNotFoundException {
        // 首先需要获取类的Class对象：这是对类的描述
        /*
         * 3种方式
         * 1：如果有对象，直接通过对象: 对象.getClass();
         * 2: 类名.class;
         * 3: Class.
         */
        Class<?> aClass = Class.forName("com.txd.modle.Student");
        System.out.println("当前类："+aClass);
        
        // 所有方法public类型方法
        Method[] methods = aClass.getMethods();
        System.out.println("===所有方法public类型方法：包含继承的=======");
        for (Method method:methods){
            System.out.println(method.toString());
        }

        // 获取所有方法public+private方法:不包含继承的
        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println("===所有方法public+private=======");
        for (Method method:declaredMethods){
            System.out.println(method.toString());
        }



    }
}
