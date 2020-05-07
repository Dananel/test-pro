package com.txd.innerclass;

/**
 * 1：内部类的权限修饰符：同样是4个
 * 2：内部类创建的时候只能通过外部类的对象创建，定义时也只能通过外部类.内部类来定义
 * 3：内部类可以访问外部类的成员 （含有外部类的引用），内部类没有静态成员
 * 4：内部类向上转型，隐藏实现细节：客户端面向接口编程
 * 5：匿名内部类：new 抽象类或者接口（没有名字，只能实现一个接口）
 * 6：如果不需要内部类和外部类有关联，那么使用嵌套类（静态内部类：没有外部类的引用，无法访问外部类的非静态成员）
 * 7：多个内部类间接实现多重继承
 */
public class Person {

     public class Info {
       public void test(){

       }
    }

    public void test() {

    }

    public Info getInfo() {
        return new Info();
    }

    public static void main(String[] args) {
        Person person = new Person();

        // 这样会报错：Info info = new Info();
        // 在外部静态方法中创建内部类，只能通过外部类创建
        Info info = person.new Info();

        Info info2 = person.getInfo();

    }
}
