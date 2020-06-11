package com.txd.mutidatasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 通过beandifinition注册数据源：可以做成配置项
 */
@Component
public class DataSourceRegister implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        // 数据源1的实现
        AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition(DruidDataSource.class);
//        abd.getPropertyValues().add("jdbcUrl", "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
//        abd.getPropertyValues().add("driverClass", "com.mysql.jdbc.Driver");
//        abd.getPropertyValues().add("username", "root");
//        abd.getPropertyValues().add("password", "root");

        abd.getPropertyValues().add("url", "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
        abd.getPropertyValues().add("driverClassName", "com.mysql.jdbc.Driver");
        abd.getPropertyValues().add("username", "root");
        abd.getPropertyValues().add("password", "root");
        beanDefinitionRegistry.registerBeanDefinition("datasource1", abd);

        // 数据源2的实现
        AnnotatedGenericBeanDefinition abd2 = new AnnotatedGenericBeanDefinition(DruidDataSource.class);
        abd2.getPropertyValues().add("url", "jdbc:mysql://localhost:3306/test2?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
        abd2.getPropertyValues().add("driverClassName", "com.mysql.jdbc.Driver");
        abd2.getPropertyValues().add("username", "root");
        abd2.getPropertyValues().add("password", "root");
        beanDefinitionRegistry.registerBeanDefinition("datasource2", abd2);

        // 动态数据源
        AnnotatedGenericBeanDefinition dynamic = new AnnotatedGenericBeanDefinition(MydatasourceManager.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("datasource1", applicationContext.getBean("datasource1"));
        map.put("datasource2", applicationContext.getBean("datasource2"));
        dynamic.getPropertyValues().add("targetDataSources", map);
        dynamic.getPropertyValues().add("datasourceChangeUtil", applicationContext.getBean(DatasourceChangeUtil.class));
        dynamic.getPropertyValues().add("defaultTargetDataSource", applicationContext.getBean("datasource1"));
        beanDefinitionRegistry.registerBeanDefinition("dynamic", dynamic);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
