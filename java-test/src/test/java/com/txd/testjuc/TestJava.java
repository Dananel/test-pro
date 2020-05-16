package com.txd.testjuc;

import org.junit.Test;

/**
 * 测试
 */
public class TestJava {

    @Test
    public void test1() {

        int[] arr ={1,2,3,4,5};

        int temp = arr[0];

        arr[0] = 3;

        System.out.println(temp);

    }
}
