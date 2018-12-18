package com.sys.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;

/**
 *
 */
@Configuration//加载配置
@EnableScheduling//启用定时任务
public class ScheduleConfig {

    // 不配置这个, 定时任务将使用默认的线程池
    @Bean
    public Executor taskScheduler(){
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);//线程数量
        scheduler.setThreadNamePrefix("scheduler-");//调度名称
        scheduler.setWaitForTasksToCompleteOnShutdown(true);//宕机时等待任务完成
        scheduler.initialize();
        return scheduler;
    }

}