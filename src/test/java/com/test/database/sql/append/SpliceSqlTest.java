package com.test.database.sql.append;

import java.io.Serializable;

/**
 *
 */
public class SpliceSqlTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        User user = new User();
        user = new UserComp();
        append(sb, user);
        System.out.println(sb);
    }

    public static void append(Serializable ser, User user){
        SqlAppend sql = SqlAppendFactory.createSqlAppend(ser);
        if(user != null){
            sql.append("REC.UTIL = 123");
        }
    }

}