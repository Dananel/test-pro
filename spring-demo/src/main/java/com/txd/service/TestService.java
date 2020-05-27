package com.txd.service;

import com.txd.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public void testAop() {
        System.out.println("TestService ..");
    }

    /**
     * 注意数据库的引擎如果是MyIsam，不支持事务。测试使用Innodb
     * 测试spring的jdbctemplate
     */
    @Transactional
    public void testSpringJdbc() {
        testDao.testDao();

        // 报错事务回滚测试
        int a = 210 % 0;
    }
}
