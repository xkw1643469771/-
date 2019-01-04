package com.test.reids;

import org.junit.Before;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class RedissonCacheTest extends RedissonTest{

    // 缓存 - 字符串
    @Test
    public void cacheForString(){
        RBucket<Object> buc = redissonClient.getBucket("buc");
        buc.set("456",10, TimeUnit.SECONDS);
        System.out.println(buc.get());
    }

    // 缓存 - map
    @Test
    public void cacheForMap() throws InterruptedException {
        RMapCache<Object, Object> map = redissonClient.getMapCache("mapTest");
        map.put("mapTestKey","mayTestVal",6000, TimeUnit.MILLISECONDS);
        System.out.println(map.get("mapTestKey"));
        Thread.sleep(1000 * 5);
        System.out.println(map.get("mapTestKey"));
    }

}