package com.itcast.mp.simple;

import com.itcast.mp.simple.mapper.UserMapper;
import com.itcast.mp.simple.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMybatisSpring {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        List<User> userList = this.userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
