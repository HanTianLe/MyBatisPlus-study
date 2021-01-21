package com.htl.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 *  实现接口的方式：
 *          将【数据库字段映】射成【实体类的枚举类型成员变量】
 */
public enum LevelEnum implements IEnum<Integer> {
    ONE(1,"一级"),
    TWO(2,"二级"),
    THREE(3,"三级");

    private Integer code;
    private String msg;

    LevelEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getValue() {
        return code;
    }
}
