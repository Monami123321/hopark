package com.ssafy.hopark.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.hopark.model.dao")
public class DBConfig {

}
