package com.zhenfeng.mysql;

import java.sql.*;

/**
 * @author Grow-Worm
 * @date 2019/06/22
 */
public class MySQLDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://140.143.201.74:4000/test", "root", "");

        Statement statement = connection.createStatement();

        statement.execute("insert into user(username, password, age, sex) value ('guanzf', '123456789', 123, 1)");
    }

}
