package com.sys.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间操作相关工具类
 */
public class TimeUtils {

    private static Logger logger = LoggerFactory.getLogger(TimeUtils.class);

    private TimeUtils(){}

    // 暂停指定毫秒
    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            logger.error("暂停" + millis + "毫秒失败", e);
        }
    }

    private static ThreadLocal<Long> lastTime = new ThreadLocal<>();

    // 仅同一个线程有效
    public static long onceTimer(){
        Long last = lastTime.get();
        lastTime.set(System.currentTimeMillis());
        if(last == null){
            return 0;
        }
        Long curr = lastTime.get();
        return curr.longValue() - last.longValue();
    }

}