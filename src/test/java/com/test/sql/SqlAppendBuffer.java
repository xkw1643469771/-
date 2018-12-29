package com.test.sql;

/**
 *
 */
public class SqlAppendBuffer implements SqlAppend{

    private StringBuffer sb;

    public SqlAppendBuffer(StringBuffer sb){
        this.sb = sb;
    }

    public void append(Object obj) {
        sb.append(obj);
    }

}