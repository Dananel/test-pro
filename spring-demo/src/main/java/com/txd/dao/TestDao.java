package com.txd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 测试dao
 */
@Repository(value = "daoTest")
public class TestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void testDao(){
        jdbcTemplate.execute("insert into test(id) values (1);");
    }
}
