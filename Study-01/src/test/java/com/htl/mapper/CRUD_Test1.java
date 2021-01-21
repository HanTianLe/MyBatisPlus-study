package com.htl.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.htl.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有查询操作
 */
@SpringBootTest
public class CRUD_Test1 {
    @Autowired
    private AccountMapper mapper;

    /**
     *  1、selectList()：通过 wrapper 设置条件查询。
     */
    @Test
    void select1(){
        /**
         *  1、不加任何条件直接查询
         *  SELECT ... FROM user WHERE deleted=0
         */
//        List<Account> accounts = mapper.selectList(null);
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
        //可以简写为：
//        mapper.selectList(null).forEach(System.out::println);

        QueryWrapper wrapper = new QueryWrapper();

        /**
         *  2、单条件查询：eq()
         *  SELECT ... FROM user WHERE deleted=0 AND (name = ?)
         */
//        wrapper.eq("name","张三");

        /**
         *  3、多条件查询：allEq()
         *  SELECT ... FROM user WHERE deleted=0 AND (name = ? AND id = ?)
         */
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","张三");
//        map.put("id",1);
//        wrapper.allEq(map);

        /**
         *  4、判断查询：lt()   （ id < 2 的）
         *  SELECT ... FROM user WHERE deleted=0 AND (id < ?)
         */
//        wrapper.lt("id",2);

        /**
         *  5、判断查询：le()   （ id <= 2 的）
         *  SELECT ... FROM user WHERE deleted=0 AND (id <= ?)
         */
//        wrapper.le("id",2);

        /**
         *  6、判断查询：gt()   （ id > 2 的）
         *  SELECT ... FROM user WHERE deleted=0 AND (id > ?)
         */
//        wrapper.gt("id",2);

        /**
         *  7、判断查询：ge()   （ id >= 2 的）
         *  SELECT ... FROM user WHERE deleted=0 AND (id >= ?)
         */
//        wrapper.ge("id",2);

        /**
         *  8、判断查询：ne()   （ name <> "张三" 的）  <>是不等号意思
         *  SELECT ... FROM user WHERE deleted=0 AND (name <> ?)
         */
//        wrapper.ne("name","张三");

        /**
         *  9、模糊查询：like()    （ name 里面带 "张" 的）
         *  SELECT ... FROM user WHERE deleted=0 AND (name LIKE ?)      ? --> %张%(String)
         */
//        wrapper.like("name","张");

        /**
         *  10、模糊查询：likeLeft()    （ name 里面是以 "张" 结尾的）
         *  SELECT ... FROM user WHERE deleted=0 AND (name LIKE ?)      ? --> %张(String)
         */
//        wrapper.likeLeft("name","张");

        /**
         *  11、模糊查询：likeRight()   （ name 里面是以 "张" 开头的）
         *  SELECT ... FROM user WHERE deleted=0 AND (name LIKE ?)      ? --> 张%(String)
         */
//        wrapper.likeRight("name","张");

        /**
         *  12、嵌套查询：inSql()
         *  SELECT ... FROM user WHERE deleted=0 AND
         *  (id IN (select id from user where id < 14) AND age IN (select age from user where age > 30))
         */
//        wrapper.inSql("id","select id from user where id < 14");
//        wrapper.inSql("age","select age from user where age > 30");

        /**
         *  13、排序：
         *      orderByAsc()     升序     SELECT ... FROM user WHERE deleted=0 ORDER BY age ASC
         *
         *      orderByDesc()    降序     SELECT ... FROM user WHERE deleted=0 ORDER BY age DESC
         */
        //根据年龄升序
//        wrapper.orderByAsc("age");
        //根据年龄降序
//        wrapper.orderByDesc("age");

        /**
         *  14、过滤声明：having()   -->在查询返回结果集以后，对查询结果进行的过滤操作。
         *  SELECT ... FROM user WHERE deleted=0 HAVING id > 8 ORDER BY age ASC
         */
        wrapper.orderByAsc("age");
        wrapper.having("id > 8");

        mapper.selectList(wrapper).forEach(System.out::println);
    }


    /**
     *  2、selectById()：通过主键查询。
     *  SELECT ... FROM user WHERE id=? AND deleted=0
     */
    @Test
    void select2(){
        System.out.println(mapper.selectById(1));
    }


    /**
     *  3、selectBatchIds()：通过主键集合查询。
     *  SELECT ... FROM user WHERE id IN ( ? , ? , ? ,.....) AND deleted=0
     */
    @Test
    void select3(){
        mapper.selectBatchIds(Arrays.asList(1,2,3)).forEach(System.out::println);
    }


    /**
     *  4、selectByMap()：通过 Map集合查询。
     *  SELECT ... FROM user WHERE name = ? AND id = ? AND deleted=0
     *
     *
     *  5、selectMaps()：将查询的结果集封装到 Map中。
     *  返回的不是对象了，而是 Key-Value的键值对形式。
     */
    @Test
    void select4(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","张三");
        mapper.selectByMap(map).forEach(System.out::println);
        System.out.println("==================================================================");

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.gt("id",1);
        mapper.selectMaps(wrapper).forEach(System.out::println);
    }


    /**
     *  6、selectCount()：计算符合条件的记录的数量。
     *  SELECT COUNT( 1 ) FROM user WHERE deleted=0 AND (id > ?)
     */
    @Test
    void select5(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.gt("id",1);
        System.out.println(mapper.selectCount(wrapper));
    }


    /**
     *  7、selectPage()：分页查询
     *  SELECT ... FROM user WHERE deleted=0 LIMIT ?,?
     *  需要在 MyBatisPlusConfig 中添加分页查询配置。
     *
     *  current： 表示查看第几页。
     *  size：    表示每页记录数。
     *
     *  getSize()：   每页几条记录
     *  getTotal()：  总记录数（表中的）
     *  getRecords()：获取当前页信息。
     *
     *
     *  8、selectMapsPage()：分页查询。 ---> 将查询的结果集封装到 Map中。
     *  返回的不是对象了，而是 Key-Value的键值对形式。
     */
    @Test
    void select6(){
        Page<Account> page = new Page<>(2,2);//表示查看第2页，每页2条记录。
        Page<Account> result = mapper.selectPage(page, null);
        System.out.println(result.getSize());
        System.out.println(result.getTotal());
        result.getRecords().forEach(System.out::println);
        System.out.println("==================================================================");

        Page<Map<String,Object>> page2 = new Page<>(1,2);
        Page<Map<String, Object>> result2 = mapper.selectMapsPage(page2, null);
        result2.getRecords().forEach(System.out::println);
    }


    /**
     *  9、selectObjs()：查询表中所有主键。 --> 返回 Object集合。
     */
    @Test
    void select7(){
        List<Object> objects = mapper.selectObjs(null);
        objects.forEach(System.out::println);
    }

    /**
     *  10、selectOne()：只返回一条记录。
     *  使用前提：返回的结果集必须是一条记录的！ 不然会包错。
     */
    @Test
    void select8(){
        //报错：Expected one result (or null) to be returned by selectOne(), but found: 9
        //System.out.println(mapper.selectOne(null));

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",1);
        //SELECT ... FROM user WHERE deleted=0 AND (id = ?)
        System.out.println(mapper.selectOne(wrapper));
    }

}
