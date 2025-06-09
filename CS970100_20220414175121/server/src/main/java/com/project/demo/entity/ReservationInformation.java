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
 *预约信息：(ReservationInformation)表实体类
 *
 */
@TableName("`reservation_information`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ReservationInformation implements Serializable {

    //ReservationInformation编号
    @TableId(value = "reservation_information_id", type = IdType.AUTO)
    private Integer reservation_information_id;
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
    // 预约时间
    @TableField(value = "`time_of_appointment`")
    private Timestamp time_of_appointment;
    // 用户姓名
    @TableField(value = "`user_name`")
    private String user_name;
    // 预约用户
    @TableField(value = "`reservation_user`")
    private Integer reservation_user;
    // 预约信息
    @TableField(value = "`reservation_information`")
    private String reservation_information;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
