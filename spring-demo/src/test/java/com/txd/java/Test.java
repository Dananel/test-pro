package com.txd.java;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 普通测试
 */
public class Test {

    @org.junit.Test
    public void test(){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(null,null);

           // Hashtable的key和value都不能是null
//        Hashtable<String, String> hashtable = new Hashtable<>();
//        hashtable.put("s",null);
    }
}
