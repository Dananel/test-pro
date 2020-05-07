package com.txd.modle;

import com.txd.access.Person;

public class Student extends Person {

    int age = 10;

    /*
     * protected: 子类访问权限，在子类可以访问到父类的default变量，直接继承
     * protected：default+子类访问权限
     *
     * public：任何地方可以访问
     *
     */
    public void testProtected(){
       skill = "test";  // 直接继承了

        // 无法访问
//        Person person = new Person();
//        person.skill = "ss";

    }

    private void testPro(){

    }
}
