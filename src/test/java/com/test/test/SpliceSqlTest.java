package com.test.test;

import com.sys.util.TimeUtils;
import com.test.sql.User;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 */
public class SpliceSqlTest {

    public static void main(String[] args) {
        Map map = new HashMap();
        map = new TreeMap();
        for (int i = 0; i < 10000*500; i++) {
            map.put(i, i);
        }
        System.out.println(map.size());
        TimeUtils.sleep(1000*1000);
        System.out.println(map.size());
    }

}