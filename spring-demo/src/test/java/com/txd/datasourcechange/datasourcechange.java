package com.txd.datasourcechange;

import com.txd.config.MainConfig;
import com.txd.mybatis.MybatisConfig;
import com.txd.mybatis.dao.TestDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class datasourcechange {

    @Test
    public void test() {

        AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(MybatisConfig.class);
        TestDao bean = context.getBean(TestDao.class);

        bean.test();

        bean.test2();
    }
}
