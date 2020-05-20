package com.txd.config;

import com.txd.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * javaconfig的方式配置启动spring
 */
@Configuration
public class MainConfig {

    @Bean
    public Student getStudent(){
        return new Student();
    }
}
