package com.htl.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.htl.enums.LevelEnum;
import com.htl.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "user")//映射数据库表名。
public class Account {
    /**
     *  @TableId的使用： 映射主键字段。
     *  value属性： 映射主键字段名。
     *  type的属性值：
     *      IdType.NONE：自动赋值，雪花算法。（默认）
     *      IdType.AUTO：数据库自增方式给主键赋值。（能够返回当前id）（如果手动给id赋值是没用的！）
     *      IdType.INPUT：需手动赋值；如果没有赋值，则数据库通过自增方式给主键赋值。
     *                   手动赋值：能够返回id。如果没有赋值，不能返回id
     *      IdType.ASSIGN_ID：自动赋值，雪花算法。
     *      IdType.ASSIGN_UUID：主键的数据类型必须是String！且会自动生成UUID进行赋值。
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer num;
    /**
     *  @TableField的使用： 映射非主键字段。
     *  value属性： 映射字段名。
     *  exist属性： 表示该属性是否为数据库字段。（值为 true或 false）
     *             如果实体类中的成员变量在数据库中没有对应的字段，则可以使用 exist。
     *  select属性： 表示是否查询该字段。（值为 true 或 false）
     */
    @TableField(value = "name")
    private String title;
    @TableField(select = true)
    private Integer age;
    @TableField(exist = false)
    private String gender;
    /**
     * 驼峰式命名：
     *      表中的是 create_time，当映射实体类时，会自动把下划线去掉，并把 t 改成 T
     *  fill属性值：
     *      FieldFill.DEFAULT：      默认不处理。
     *      FieldFill.INSERT：       插入时填充字段。
     *      FieldFill.UPDATE：       更新时填充字段。
     *      FieldFill.INSERT_UPDATE：插入和更新时填充字段。
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * @Version的使用： 乐观锁注解。（主要是用来防止多线程操作）
     *      通过version字段来保证数据的安全性，当修改数据的时候，会以version作为条件，
     *      当条件成立的时候才会修改成功。
     *
     *  数据库表添加 version字段，默认值为 1
     *  实体类添加 version成员变量，并且添加 @Version注解。
     */
    @Version
    private Integer version;
    /**
     * @EnumValue的使用： 通用枚举注解，
     *                  将【数据库字段映】射成【实体类的枚举类型成员变量】
     *
     *  注意：成员变量的名字一定要跟数据库的字段对应！
     *      如果非要不一样可以添加注释：@TableField(value = "status")
     *
     *  别忘了在 application.yml当中添加（枚举包扫描）：
     *      type-enums-package: com.htl.enums
     */
    private StatusEnum status;
    @TableField(value = "level")
    private LevelEnum levelEnum;
    /**
     * @TableLogic的使用： 映射逻辑删除。其实并不是真正意义上的删除，只是用一个属性的值表示该记录是否被删除。
     *  1、数据库表添加 deleted 字段。
     *  2、实体类添加注解。
     *  3、application.yml添加配置：
     *      global-config:
     *        db-config:
     *          logic-not-delete-value: 0
     *          logic-delete-value: 1
     *
     *  0 表示没被删，1 表示被删。
     *  如果表中某条记录的 deleted=1了，那么这条记录用 select是查询不出来的。
     */
    @TableLogic
    private Integer deleted;

}
