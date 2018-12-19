package com.test.mybatis.generator.custom;

import org.mybatis.generator.api.ConnectionFactory;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.config.ConnectionFactoryConfiguration;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.JDBCConnectionFactory;
import org.mybatis.generator.internal.ObjectFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 自定义注解
 */
public class CustomComment extends DefaultCommentGenerator {

/*    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        System.out.println(field);
    }*/

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String comment = "";
        try {
            ConnectionFactory connectionFactory = new JDBCConnectionFactory(introspectedColumn.getContext().getJdbcConnectionConfiguration());
            Connection connection = connectionFactory.getConnection();
            String sql =
                    "SELECT T.COMMENTS FROM ALL_COL_COMMENTS T WHERE T.TABLE_NAME = ? AND T.COLUMN_NAME = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, introspectedTable.getTableConfiguration().getTableName());
            ps.setString(2, introspectedColumn.getActualColumnName());
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                comment = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        StringBuilder javaDoc = new StringBuilder();
        javaDoc.append("/** ");
        javaDoc.append(comment);
        javaDoc.append(" */");
        field.addJavaDocLine(javaDoc.toString());
    }

}
