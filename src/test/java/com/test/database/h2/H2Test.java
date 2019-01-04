package com.test.database.h2;

import com.test.database.DatabaseUtils;
import org.h2.tools.Server;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class H2Test{

    Connection connection;

    // 启动服务, 通过浏览器管理数据库
    public static void main(String[] args) throws SQLException {
        Server.createWebServer().start();
        System.out.println("http://localhost:8082");
    }

    @Before
    public void initH2DB() throws Exception {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:./h2/test","root","root");
    }

    @Test
    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE MY_TEST(id int, name varchar(255))");
    }

    @Test
    public void insertTable() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO USER VALUES (?,?)");
        for (int i = 0; i < 10000*1000; i++) {
            ps.setInt(1, i);
            ps.setString(2,String.valueOf(i));
            ps.addBatch();
            if(i % 10000 == 0){
                ps.executeBatch();
                ps.clearBatch();
            }
        }
    }

    @Test
    public void select() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM USER");
        DatabaseUtils.printResultSet(resultSet);
    }

}