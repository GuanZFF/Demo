package pers.zhenfeng.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;


/**
 * @author Grow-Worm
 * @date 2019/04/20
 */
public class MybatisDemo {

    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        System.out.println("-------------------------------------------");
        users.forEach(item ->{
            System.out.println(item.getId() + " : " + item.getUsername() + " : " + item.getPassword());
            System.out.println("-------------------------------------------");
        });
    }

}
