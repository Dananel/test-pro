package com.txd.propertiestest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component("testproperties")
@PropertySource("classpath:test.properties")
public class Student {
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;
}
