package com.sys.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;

/**
 *
 */
@EnableAsync//启动异步
@Configuration//加载配置, 不写启用异步不生效
public class AsyncConfig {

    // 不配置这个, 异步任务将使用默认的线程池
    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);//线程池大小
        taskExecutor.setThreadNamePrefix("task-");//线程名称
        taskExecutor.setQueueCapacity(256);//任务队列容量
        taskExecutor.setMaxPoolSize(100);//最大线程数
        taskExecutor.initialize();
        return taskExecutor;
    }

}