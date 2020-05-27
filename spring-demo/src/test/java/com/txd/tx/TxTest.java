package com.txd.tx;

import com.txd.config.MainConfig;
import com.txd.service.TestService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring事务：
 * 1：@EnableTransactionManagement开启事务
 * 2：注入事务管理器（有数据源）
 * 3： 使用注解：@Transactional
 */
public class TxTest {
    private static AnnotationConfigApplicationContext context;

    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext(MainConfig.class);
    }

    @Test
    public void test() {
        TestService bean = context.getBean(TestService.class);
        bean.testSpringJdbc();
    }
}
