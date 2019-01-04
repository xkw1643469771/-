package com.test.database.hsql;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class HSqlConnPoolTest extends AbstractHsqlDB{

    Connection connection;

    @Before
    public void initPool2() throws SQLException {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        hikariDataSource.setJdbcUrl("jdbc:hsqldb:file:./hsql/test");
        hikariDataSource.setUsername("sa");
        hikariDataSource.setPassword("");
        connection = hikariDataSource.getConnection();
    }

    @Test
    public void select() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM USER ");
        printResultSet(resultSet);
    }

}