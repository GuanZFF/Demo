package pers.zhenfeng.spring;

import org.apache.ibatis.annotations.Select;
import pers.zhenfeng.mybatis.User;

import java.util.List;

/**
 * @author Grow-Worm
 * @date 2019/04/20
 */
public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

}
