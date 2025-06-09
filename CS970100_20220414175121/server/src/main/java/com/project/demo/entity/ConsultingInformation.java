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
 *咨询信息：(ConsultingInformation)表实体类
 *
 */
@TableName("`consulting_information`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ConsultingInformation implements Serializable {

    //ConsultingInformation编号
    @TableId(value = "consulting_information_id", type = IdType.AUTO)
    private Integer consulting_information_id;
    // 咨询师姓名
    @TableField(value = "`consultant_name`")
    private String consultant_name;
    // 咨询师用户
    @TableField(value = "`consultant_user`")
    private Integer consultant_user;
    // 咨询师性别
    @TableField(value = "`consultant_gender`")
    private String consultant_gender;
    // 咨询方向
    @TableField(value = "`consulting_direction`")
    private String consulting_direction;
    // 回复状态
    @TableField(value = "`reply_status`")
    private String reply_status;
    // 用户姓名
    @TableField(value = "`user_name`")
    private String user_name;
    // 咨询用户
    @TableField(value = "`consulting_users`")
    private Integer consulting_users;
    // 咨询内容
    @TableField(value = "`consultation_content`")
    private String consultation_content;
    // 咨询回复
    @TableField(value = "`consultation_reply`")
    private String consultation_reply;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
