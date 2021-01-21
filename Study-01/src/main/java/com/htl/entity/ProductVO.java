package com.htl.entity;

import lombok.Data;

@Data
public class ProductVO {
    private Integer category;
    private Integer count;
    private String description;
    //这边的 userId 之所以能与数据库中的 user_id 映射，因为下划线这种格式能够进行驼峰式命名法映射。
    private Integer userId;
    private String userName;
}

