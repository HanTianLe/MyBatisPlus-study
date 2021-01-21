package com.htl.mapper;

import com.htl.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountMapperTest {

    @Autowired
    private AccountMapper mapper;

    //枚举测试
    @Test
    void show(){
        mapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void save(){
        Account account = new Account();
//        account.setNum(4);
        account.setTitle("韩七");
        account.setAge(50);
        mapper.insert(account);
        System.out.println(account);
    }

    //@Version测试1
    @Test
    void update(){
        Account account = mapper.selectById(2);
        System.out.println(account.getVersion());//1
        account.setTitle("李四");
        //UPDATE user SET name=?, update_time=?, version=? WHERE id=? AND version=?
        mapper.updateById(account);
        System.out.println(account.getVersion());//2
    }

    //@Version测试2
    @Test
    void update2(){
        //update...version = 2 where version = 1
        Account account1 = mapper.selectById(1);
        account1.setTitle("张三1");
        //update...version = 2 where version = 1
        Account account2 = mapper.selectById(1);
        account1.setTitle("张三2");
        mapper.updateById(account1);//执行（执行后，version = 2 了）
        mapper.updateById(account2);//没执行
    }

    //@TableLogic：逻辑删除测试
    @Test
    void deleted(){
        //UPDATE user SET deleted=1 WHERE id=? AND deleted=0
        mapper.deleteById(1);
    }
    
}

