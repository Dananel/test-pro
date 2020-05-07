package com.txd.colleection.testlist;

import java.util.ArrayList;
import java.util.Vector;

public class TestList {

    /**
     * 线程安全的类：对集合的修改：方法通过synchronized关键字进行同步
     */
    public void testVector(){
        Vector<String> vectors = new Vector<>();

        // 添加一个元素
        boolean test1 = vectors.add("test1"); // 通用方法，返回成功或者失败
        vectors.addElement("test2");  // vector自己实现的

        // 添加多个元素
        ArrayList<String> strings = new ArrayList<>();
        strings.add("123");
        strings.add("456");
        // vectors.addAll(strings);

        // 在索引位置上开始插入一个元素，后面的后移
        vectors.add(0,"add index");
        // 索引处开始插入多个元素
        vectors.addAll(0,strings);



        System.out.println(vectors);
    }

    public static void main(String[] args) {
        TestList testList = new TestList();
        testList.testVector();
    }
}
