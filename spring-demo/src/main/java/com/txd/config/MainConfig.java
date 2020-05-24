package com.txd.config;

import com.txd.conditional.MyConditionTest;
import com.txd.model.ConditionTestModel;
import com.txd.model.ImportModel;
import com.txd.model.Student;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * javaconfig的方式配置启动spring
 */
@Configuration
@ComponentScan("com.txd")
@Import({ImportModel.class})
@EnableAspectJAutoProxy
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
}
