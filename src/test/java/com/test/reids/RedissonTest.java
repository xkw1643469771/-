package com.test.reids;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 *
 */
public class RedissonTest {

    // 纯手动连接Redis
    @Test
    public void redissonJavaConnection(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.1.202:6379");
        RedissonClient redissonClient = Redisson.create(config);
    }



}