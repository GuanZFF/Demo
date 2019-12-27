package com.zhenfeng.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Grow-Worm
 * @date 2019/11/24
 */
public class MySQLDemo2 {

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://106.12.37.25:3306/test", "guanzf", "");

        Statement statement = connection.createStatement();

        ResultSet query = statement.executeQuery("select * from t1");

        while (query.next()) {
            System.out.println(query.getInt(1));
        }

    }

}
