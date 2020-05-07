package com.txd.abstractclass;

import com.txd.interfaces.TestInterface;

/**
 * 1：抽象类可以有main方法
 * 2: 抽象类可以实现接口
 * 3：可以继承具体的类
 * 4: new关键字创建对象的时候，必须实现所有的抽象方法
 * 5：使用接口的优点：
 *    1》接口提供一系列规范性
 *    2》面向接口编程更灵活 （不绑定某一个实现，绑定一系列实现）
 *    3》耦合性降低（不关注具体实现）
 */
public abstract class TestAbstractClass extends Test implements TestInterface {



    public static void main(String[] args) {
        System.out.println("抽像类可以有main方法");

        // new关键字创建对象的时候，必须实现所有的抽象方法
        TestAbstractClass testAbstractClass = new TestAbstractClass(){
            @Override
            public void test() {

            }
        };
    }
}
