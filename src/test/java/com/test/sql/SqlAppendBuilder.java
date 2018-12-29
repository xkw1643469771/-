package com.test.sql;

/**
 *
 */
public class SqlAppendBuilder implements SqlAppend{

    private StringBuilder sb;

    public SqlAppendBuilder(StringBuilder sb){
        this.sb = sb;
    }

    public void append(Object obj) {
        sb.append(obj);
    }

}