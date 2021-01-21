package com.htl.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StatusEnum {
    WORK(1,"上班"),
    REST(0,"休息");

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @EnumValue的使用： 通用枚举注解，将数据库字段映射成实体类的枚举类型成员变量。
     */
    @EnumValue
    private Integer code;
    private String msg;

}
