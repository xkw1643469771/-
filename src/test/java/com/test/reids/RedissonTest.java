package com.test.reids;

import org.junit.Before;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public abstract class RedissonTest{

    RedissonClient redissonClient;

    @Before
    public void initRedission(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.1.202:6379");
        config.useSingleServer().setDatabase(15);
        redissonClient = Redisson.create(config);
    }

}