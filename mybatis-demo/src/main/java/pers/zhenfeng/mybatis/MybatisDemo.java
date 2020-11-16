package pers.zhenfeng.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author Grow-Worm
 * @date 2019/04/20
 */
public class MybatisDemo {

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        factory.getConfiguration().addInterceptor(new TestInterceptor());


        executorService.execute(() -> {
            SqlSession sqlSession = factory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.getUsers();

            mapper.getUsers();
            sqlSession.close();
        });

        executorService.execute(() -> {
            SqlSession sqlSession = factory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.getUsers();
            sqlSession.close();
        });

        executorService.shutdown();
    }

}
