package com.txd.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestMapper {

    @Select("select * from test")
    List<String> query();
}
