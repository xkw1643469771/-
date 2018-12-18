package com.sys.util;

import org.slf4j.LoggerFactory;

/**
 *
 */
public class LogUtils {

    private LogUtils(){}

    public static void info(String msg){
        LoggerFactory.getLogger(callClassName()).info(msg);
    }

    private static String callClassName(){
        return Thread.getAllStackTraces().get(Thread.currentThread())[4].getClassName();
    }

    private static String callLine(){
        return ""+Thread.getAllStackTraces().get(Thread.currentThread())[4].getLineNumber();
    }

    public static void main(String[] args) {
        LogUtils.info("123213");
    }

}