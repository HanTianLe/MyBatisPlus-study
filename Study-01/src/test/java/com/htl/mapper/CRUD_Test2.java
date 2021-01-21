package com.htl.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.htl.entity.Account;
import com.htl.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  自定义 SQL，多表关联。
 *
 *  插入操作。
 *  删除操作。
 *  修改操作。
 */
@SpringBootTest
public class CRUD_Test2 {
    @Autowired
    private AccountMapper mapper;

    @Autowired
    private UserMapper userMapper;


    /**
     *  自定义 SQL，多表关联。
     */
    @Test
    void product(){
        mapper.productList(1).forEach(System.out::println);
    }

    /**
     *  插入：insert()
     */
    @Test
    void save(){
        Account account = new Account();
        account.setTitle("插入后删除");
        account.setAge(33);
        mapper.insert(account);
        System.out.println(account);
    }

    /**
     *  删除：deleteById()：通过主键删除。
     *  DELETE FROM user WHERE id=?     --> 18(Integer)
     */
    @Test
    void delete1(){
        //这边不用实体类为：Account 的 mapper，因为里面有逻辑删除。
        userMapper.deleteById(18);
    }

    /**
     *  删除：deleteBatchIds()：通过主键集合删除。
     *  DELETE FROM user WHERE id IN ( ? , ? , ? )  --> 19(Integer), 20(Integer), 21(Integer)
     */
    @Test
    void delete2(){
        userMapper.deleteBatchIds(Arrays.asList(19,20,21));
    }

    /**
     *  删除：delete()：通过 wrapper 设置条件删除。
     */
    @Test
    void delete3(){
        QueryWrapper wrapper = new QueryWrapper();
        // DELETE FROM user WHERE (age = ?)
        wrapper.eq("age",14);
        userMapper.delete(wrapper);
    }

    /**
     *  删除：deleteByMap()：通过 Map集合删除。
     *  DELETE FROM user WHERE name = ? AND id = ?  --> 测试(String), 100(Integer)
     */
    @Test
    void delete4(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",100);
        map.put("name","测试");
        userMapper.deleteByMap(map);
    }

    /**
     *  修改：updateById()：通过主键修改。
     *  UPDATE user SET name=?, update_time=? WHERE id=?
     */
    @Test
    void update1(){
        User user = new User();
        user.setId(23);
        user.setName("测试2");
        userMapper.updateById(user);
    }

    /**
     *  修改：update()：通过 对象 和 wrapper 设置条件修改。
     *  UPDATE user ... WHERE (age = ? AND version = ?)
     */
    @Test
    void update2(){
        User user = userMapper.selectById(23);
        user.setName("测试3");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("age",11);
        userMapper.update(user,wrapper);
    }
}

