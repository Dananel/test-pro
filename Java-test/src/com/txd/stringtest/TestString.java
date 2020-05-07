package com.txd.stringtest;

public class TestString {

    public static void main(String[] args) {
        // 字符串反转
        String testStr1 = "hello world";
        StringBuilder builder = new StringBuilder(testStr1);
        StringBuilder reverse = builder.reverse();
        System.out.println(reverse.toString());

        // 字符串替换: 以新的字符串替换旧的
        System.out.println(testStr1.replace("o","12"));

        // 正则匹配替换：替换所有匹配，替换第一个匹配
//        testStr1.replaceAll()
//        testStr1.replaceFirst()
        
        // 字符串截取：索引含前不含后
        String substring = testStr1.substring(0, 1);
        System.out.println("字符串截取："+substring);

        // 字符串分割
        testStr1.split("\\|");
        
        // 字符串转成字符数组
        char[] chars = testStr1.toCharArray();


    }
}
