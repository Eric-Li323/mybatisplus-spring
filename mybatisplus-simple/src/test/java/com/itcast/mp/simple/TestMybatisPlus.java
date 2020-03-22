package com.itcast.mp.simple;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.itcast.mp.simple.mapper.UserMapper;
import com.itcast.mp.simple.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class TestMybatisPlus {
    @Test
    public void testFindAll() throws Exception{
        String config= "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);

        //MybatisSqlSessionFactoryBuilder  替换 SqlSessionFactoryBuilder，完成mybatisplus整合，其他不变
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //测试查询
//        List<User> userList = userMapper.findAll();
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
