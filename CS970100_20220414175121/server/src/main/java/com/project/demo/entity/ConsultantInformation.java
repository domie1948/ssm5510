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
 *咨询师信息：(ConsultantInformation)表实体类
 *
 */
@TableName("`consultant_information`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ConsultantInformation implements Serializable {

    //ConsultantInformation编号
    @TableId(value = "consultant_information_id", type = IdType.AUTO)
    private Integer consultant_information_id;
    // 咨询师姓名
    @TableField(value = "`consultant_name`")
    private String consultant_name;
    // 咨询师性别
    @TableField(value = "`consultant_gender`")
    private String consultant_gender;
    // 咨询方向
    @TableField(value = "`consulting_direction`")
    private String consulting_direction;
    // 咨询师头像
    @TableField(value = "`consultant_avatar`")
    private String consultant_avatar;
    // 咨询师用户
    @TableField(value = "`consultant_user`")
    private Integer consultant_user;
    // 个人简介
    @TableField(value = "`personal_profile`")
    private String personal_profile;
    // 点击数
    @TableField(value = "hits")
    private Integer hits;
    // 点赞数
    @TableField(value = "praise_len")
    private Integer praise_len;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
