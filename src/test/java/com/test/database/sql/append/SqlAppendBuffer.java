package com.test.database.sql.append;

/**
 *
 */
public class SqlAppendBuffer implements SqlAppend{

    private StringBuffer sb;

    public SqlAppendBuffer(StringBuffer sb){
        this.sb = sb;
    }

    public SqlAppend append(Object obj) {
        sb.append(obj);
        return this;
    }

}