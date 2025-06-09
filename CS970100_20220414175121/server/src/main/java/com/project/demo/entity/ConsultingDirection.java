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
 *咨询方向：(ConsultingDirection)表实体类
 *
 */
@TableName("`consulting_direction`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ConsultingDirection implements Serializable {

    //ConsultingDirection编号
    @TableId(value = "consulting_direction_id", type = IdType.AUTO)
    private Integer consulting_direction_id;
    // 咨询方向
    @TableField(value = "`consulting_direction`")
    private String consulting_direction;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
