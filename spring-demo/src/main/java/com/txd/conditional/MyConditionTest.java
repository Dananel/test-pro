package com.txd.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 用于过滤bean：符合条件的才加入容器（true），否则不加入
 */
public class MyConditionTest implements Condition {

    /**
     * 满足条件才注册到容器
     *
     * @param conditionContext      可以获取到bean工厂，环境信息，beandefinition注册器
     * @param annotatedTypeMetadata 标注@Conditional注解的类的注解信息
     * @return 是否加入容器
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // beanfactory
        ConfigurableListableBeanFactory factory = conditionContext.getBeanFactory();
        // BeanDefinition注册器
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        // 环境信息
        Environment environment = conditionContext.getEnvironment();
        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
