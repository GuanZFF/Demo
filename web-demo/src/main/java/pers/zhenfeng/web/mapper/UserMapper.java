package pers.zhenfeng.web.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Grow-Worm
 * @date 2019/12/24
 */
@Mapper
public interface UserMapper {


    @Select("select * from user")
    List<User> queryUser();

    @Insert("insert into user(username, password) value(#{user.username}, #{user.password})")
    Integer insertUser(@Param("user") User user);

    @Select("select * from user where username = #{username}")
    User getUser(@Param("username") String username);

}
