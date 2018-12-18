package com.sys.async;

import com.sys.util.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 *
 */
@Service
public class AsyncTestService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async// 开启异步, 方法被调用时会开启新的线程
    public void test1(){
        TimeUtils.sleep(2000);
        logger.info("test1");
    }

}