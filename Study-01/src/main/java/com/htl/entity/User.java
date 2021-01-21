package com.htl.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.htl.enums.LevelEnum;
import com.htl.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private Integer version;
    private StatusEnum status;
    @TableField(value = "level")
    private LevelEnum levelEnum;
    private Integer deleted;
}

