package pers.zhenfeng.base;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author Grow-Worm
 * @date 2019/12/24
 */
public class SQLTest {

    public static void main(String[] args) {
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("user");
        sql.WHERE("username = guanzf");
        sql.WHERE("password = 123");
        System.out.println(sql.toString());
    }

}
