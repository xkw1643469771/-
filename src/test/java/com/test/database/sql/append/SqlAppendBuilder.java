package com.test.database.sql.append;

/**
 *
 */
public class SqlAppendBuilder implements SqlAppend{

    private StringBuilder sb;

    public SqlAppendBuilder(StringBuilder sb){
        this.sb = sb;
    }

    public SqlAppend append(Object obj) {
        sb.append(obj);
        return this;
    }

}