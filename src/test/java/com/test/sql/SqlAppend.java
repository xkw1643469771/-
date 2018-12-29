package com.test.sql;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 *
 */
public interface SqlAppend {

    void append(Object obj);

    static void appendSql(Serializable ser, Object obj){
        SqlAppend sqlAppend = SqlAppendFactory.createSqlAppend(ser);
        Class objClass = obj.getClass();
        for (Field field : objClass.getDeclaredFields()){
            System.out.println(field);
        }
        for (Field field : objClass.getFields()){
            System.out.println(field);
        }
    }

}