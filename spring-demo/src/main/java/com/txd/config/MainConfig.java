package com.txd.config;

import com.txd.conditional.MyConditionTest;
import com.txd.model.ConditionTestModel;
import com.txd.model.ImportModel;
import com.txd.model.Student;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * javaconfig的方式配置启动spring
 */
@EnableTransactionManagement  // 开启事务
@EnableAspectJAutoProxy   // 开启aop
@Configuration
@ComponentScan("com.txd")
@Import({ImportModel.class})
public class MainConfig {

    @Bean
    @Conditional({MyConditionTest.class})
    public Student getStudent(){
        return new Student();
    }

    @Bean
    @Conditional({MyConditionTest.class})
    public ConditionTestModel getTestModel(){
        return new ConditionTestModel();
    }

    /**
     * 创建jdbctemplate
     *
     * @param dataSource 数据源
     * @return jdbctemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource  dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    /**
     * 获取事务管理器
     *
     * @param dataSource 数据源
     * @return 事务管理器
     */
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
