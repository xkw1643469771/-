package com.sys.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * mybatis 配置
 */
@MapperScan("com.sys.mybatis.dao")//扫描mapper接口
@Configuration
public class MyBatisConfig {

}