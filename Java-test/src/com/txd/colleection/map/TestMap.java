package com.txd.colleection.map;

import java.util.HashMap;

public class TestMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(null,"1");
        map.put(null,null);


        System.out.println(map.get(null));
    }
}
