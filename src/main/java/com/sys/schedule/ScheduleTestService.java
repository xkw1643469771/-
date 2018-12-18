package com.sys.schedule;

import com.sys.util.LogUtils;
import com.sys.util.TimeUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;

/**
 *
 */
@Service
public class ScheduleTestService {

    @Async
    public void test1(){
        TimeUtils.sleep(2000);
        LogUtils.info("定时任务1");
    }

}