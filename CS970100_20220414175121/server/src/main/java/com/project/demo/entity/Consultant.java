package com.project.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 *咨询师：(Consultant)表实体类
 *
 */
@TableName("`consultant`")
@Data
@EqualsAndHashCode(callSuper = false)
public class Consultant implements Serializable {

    //Consultant编号
    @TableId(value = "consultant_id", type = IdType.AUTO)
    private Integer consultant_id;
    // 咨询师姓名
    @TableField(value = "`consultant_name`")
    private String consultant_name;
    // 咨询师性别
    @TableField(value = "`consultant_gender`")
    private String consultant_gender;
    // 用户编号
    @TableField(value = "user_id")
    private Integer userId;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
