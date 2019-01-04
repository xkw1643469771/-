package com.test.database.hsql;

import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * hsql Standalone 数据库测试
 * 默认建立的数据库有缓存, 解决方式如下:
 *     在 test.script 中修改 SET FILES WRITE DELAY 0 保证数据的实时性, 但是会降低性能
 *     使用 SHUTDOWN 命令刷出缓存到文件
 *     在url后面加 SHUTDOWN 参数, 比如: jdbc:hsqldb:file:./hsql/test2;shutdown=true
 */
public class HSqlDBTest extends AbstractHsqlDB{

    private Connection connection;

    // 启动数据库管理器
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DatabaseManagerSwing.main(args);
    }

    //客户端 Standalone 模式
    @Before
    public void initHsql() throws Exception {
        Class.forName("org.hsqldb.jdbcDriver");
        connection = DriverManager.getConnection("jdbc:hsqldb:file:./hsql/test", "sa", "");
        //connection = DriverManager.getConnection("jdbc:hsqldb:file:d:/hsql/test", "sa", "");
        //shutdown 设置问true, 表示每次关闭连接都会把数据刷新到文件, 另一种方式是自己执行shutdown命令
        //connection = DriverManager.getConnection("jdbc:hsqldb:file:./hsql/test2;shutdown=true", "sa", "");
    }

    //@After
    public void exitHsql() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("SHUTDOWN");//刷出缓存到文件
        statement.close();
        connection.close();
    }

    @Test
    public void select() throws SQLException {
        long s1 = System.currentTimeMillis();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from user");
        printResultSet(rs);
        System.out.println(System.currentTimeMillis() - s1);
    }

    //插入
    @Test
    public void inset10000() throws Exception{
        Statement st = connection.createStatement();
        Random r = new Random();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                int val = 114;
                st.execute("INSERT INTO USER (ID,NAME) VALUES (" + val + ",'TOM')");
            }
        }
        Thread.sleep(10000);
        //st.execute("SHUTDOWN");
    }

}