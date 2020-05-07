package com.txd.access;

import com.txd.modle.Student;

/**
 * 测试java的访问权限控制：private < default(friendly) < protected < public
 */
public class AccessTest {
    /*
    * 1：private类型的方法只能在本类中使用，private的变量也是只能本类访问（注意：此处访问指的是，直接访问，不能通过方法访问字段）
    * 2：default修饰的只能本包内访问
     */
    public void testDefault(){
        // 1: modle包中的Student类的age属性是default的，此处无法访问
//        Student student = new Student();
//        student.age = 12;

        // 2：同一个包中的字段可以访问
        Book book = new Book();
        book.name = "数学";
    }


}
