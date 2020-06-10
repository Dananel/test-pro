package com.txd.mutidatasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * 注入多个数据源
 */
@Configuration
public class DataSourceConfig {

    @Bean("datasource1")
    public DataSource getDatasource1() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        return druidDataSource;
    }

    @Bean("datasource2")
    public DataSource getDatasource2() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test2?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        return druidDataSource;
    }

    @Bean
    public MydatasourceManager dynamic(DatasourceChangeUtil datasourceChangeUtil) {
        MydatasourceManager mydatasourceManager = new MydatasourceManager();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("datasource1",getDatasource1());
        map.put("datasource2",getDatasource2());
        mydatasourceManager.setTargetDataSources(map);
        mydatasourceManager.setDatasourceChangeUtil(datasourceChangeUtil);
        mydatasourceManager.setDefaultTargetDataSource(getDatasource1());
        return mydatasourceManager;
    }
}
