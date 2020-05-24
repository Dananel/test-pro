package com.txd.aop;

import com.txd.Aop.Aop;
import com.txd.config.MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试aop
 */
public class Test2Aop {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        Aop bean = context.getBean(Aop.class);

        bean.test1("123");
    }
}
