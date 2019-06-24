package com.zhenfeng.mysql;

import java.sql.*;

/**
 * @author Grow-Worm
 * @date 2019/06/22
 */
public class MySQLDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://www.gzhenfeng.cn:8066/TESTDB?useSSL=false&serverTimezone=UTC", "root", "123456");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from t3 order by id");

        while (resultSet.next()) {
            System.out.println("数据" + resultSet.getInt(1) + " " + resultSet.getInt(2));
        }
    }

}
