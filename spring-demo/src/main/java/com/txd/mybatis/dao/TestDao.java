package com.txd.mybatis.dao;

import com.txd.mybatis.mapper.TestMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class TestDao {
    @Autowired
    private TestMapper testMapper;

    /**
     * testMapper: jdk动态代理产生
     */
    public void test(){
        System.out.println(testMapper.query());
    }
}
