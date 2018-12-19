package com.test.mybatis.generator.custom;

import org.mybatis.generator.api.ConnectionFactory;
import org.mybatis.generator.api.PluginAdapter;

import java.util.List;
import java.util.Properties;

/**
 *
 */
public class PropertiesPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        System.out.println(warnings);
        return true;
    }

    @Override
    public void setProperties(Properties properties) {
    }
}