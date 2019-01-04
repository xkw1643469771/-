package com.test.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class DatabaseUtils {

    public static void printResultSet(ResultSet rs) throws SQLException {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            sb.append(rs.getMetaData().getColumnName(i)).append("\t");
        }
        System.out.println(sb.toString());
        while(rs.next()){
            sb.setLength(0);
            for (int i = 1;i <= rs.getMetaData().getColumnCount() ; i++) {
                sb.append(rs.getObject(i)).append("\t");
            }
            System.out.println(sb.toString());
        }

    }

}