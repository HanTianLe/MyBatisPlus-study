package com.htl.mapper;

import com.htl.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void test(){
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void save(){
        User user = new User();
        user.setName("赵六");
        user.setAge(40);
        userMapper.insert(user);
        System.out.println(user);
    }

}

