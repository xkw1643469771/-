package com.test.sql;

import java.io.Serializable;

/**
 *
 */
public class SpliceSqlTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        User user = new User();
        user = new UserComp();
        SqlAppend.appendSql(sb, user);
    }

}