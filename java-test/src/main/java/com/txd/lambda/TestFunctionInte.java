package com.txd.lambda;

import java.util.function.Function;
import java.util.function.IntSupplier;

/**
 * 测试函数式接口:lambda实现
 */
public class TestFunctionInte {

    public String testFunction(){

        IntSupplier func = ()-> {return 1;};
        System.out.println(func.getAsInt());

        Function<String,String> fuu = (str)-> {return str;};

        System.out.println(fuu.apply("123"));
        return null;

    }

}
