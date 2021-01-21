package com.htl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.htl.entity.Account;
import com.htl.entity.ProductVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper extends BaseMapper<Account> {
    /**
     *  自定义 SQL，多表关联。
     */
    @Select("select p.*,u.name userName from product p,user u where p.user_id=u.id and u.id = #{userId}")
    List<ProductVO> productList(Integer userId);

}
