package com.htl.generator.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountMapperTest {

    @Autowired
    private AccountMapper mapper;

    @Test
    void show(){
        mapper.selectList(null).forEach(System.out::println);
    }

}

