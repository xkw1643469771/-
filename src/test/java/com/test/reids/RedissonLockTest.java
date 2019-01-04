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
public class RedissonLockTest extends RedissonTest{

    // 锁测试-简单用法
    @Test
    public void lockForRLock() throws InterruptedException {
        RLock lock = redissonClient.getLock("123123");
        lock.lock();
        Thread.sleep(1000*10);
        if(lock.isHeldByCurrentThread()){
            lock.unlock();
        }
    }

    // 锁测试-可重入测试
    @Test
    public void lockForReentrant() throws InterruptedException {
        RLock lock = redissonClient.getLock("reentrant");
        lock.lock();
        System.out.println("上锁");
        lockForReentrant2();
        if(lock.isHeldByCurrentThread()){
            lock.unlock();
            System.out.println("解锁");
        }
    }
    public void lockForReentrant2() throws InterruptedException {
        RLock lock = redissonClient.getLock("reentrant");
        lock.lock();
        System.out.println("重入上锁");
        if(lock.isHeldByCurrentThread()){
            lock.unlock();
            System.out.println("重入解锁");
        }
    }

    // 锁测试 - 读读 - 读读不互斥 - 读写互斥
    @Test
    public void lockForReadLock() throws InterruptedException {
        RLock lock = redissonClient.getReadWriteLock("readWriteLock").readLock();
        lock.lock();
        System.out.println("读写锁-读读测试");
        Thread.sleep(1000*20);
        if(lock.isHeldByCurrentThread()){
            System.out.println("解锁");
            lock.unlock();
        }
    }

    // 锁测试 - 写写 - 写写互斥 - 写读互斥
    @Test
    public void lockForWriteLock() throws InterruptedException {
        RLock lock = redissonClient.getReadWriteLock("readWriteLock").writeLock();
        lock.lock();
        System.out.println("读写锁-写写测试");
        Thread.sleep(1000*20);
        if(lock.isHeldByCurrentThread()){
            System.out.println("解锁");
            lock.unlock();
        }
    }

    // 锁测试 - 公平锁 - 先到先得, 效率低(指定线程才能获取, 线程切换多)
    @Test
    public void lockForFariLock1() throws InterruptedException {
        RLock lock = redissonClient.getFairLock("fair");
        lock.lock();
        System.out.println("公平锁lockForFariLock1");
        Thread.sleep(1000*20);
        if(lock.isHeldByCurrentThread()){
            System.out.println("解锁");
            lock.unlock();
        }
    }

}