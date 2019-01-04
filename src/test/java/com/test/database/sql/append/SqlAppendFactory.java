package com.test.database.sql.append;

import java.io.Serializable;

/**
 *
 */
public class SqlAppendFactory {

    public static SqlAppend createSqlAppend(Serializable serializable){
        SqlAppend sqlAppend = null;
        if(serializable instanceof StringBuilder){
            sqlAppend = new SqlAppendBuilder((StringBuilder) serializable);
        }else if(serializable instanceof StringBuffer){
            sqlAppend = new SqlAppendBuffer((StringBuffer) serializable);
        }
        return sqlAppend;
    }

}