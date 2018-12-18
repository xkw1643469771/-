package com.sys.schedule;

import com.sys.util.LogUtils;
import com.sys.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

/**
 *
 */
@RestController
public class ScheduleTestController {

    @Autowired
    private ScheduleTestService testService;

    // 测试定时任务
    @Scheduled(cron = "0/1 * 1 * * ?")//每秒执行一次
    public void test1(){
        LogUtils.info("test2");
    }

    // 测试定时任务调异步任务
    @Scheduled(cron = "0/5 * 1 * * ?")//每5秒执行一次
    public void test2(){
        testService.test1();
        testService.test1();
        testService.test1();
        testService.test1();
    }

    // 测试定时任务加异步
    @Async
    @Scheduled(cron = "0/5 * 1 * * ?")//每5秒执行一次
    public void test3(){
        LogUtils.info("定时加异步");
    }

}