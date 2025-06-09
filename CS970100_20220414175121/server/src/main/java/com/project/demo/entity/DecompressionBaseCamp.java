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
 *减压大本营：(DecompressionBaseCamp)表实体类
 *
 */
@TableName("`decompression_base_camp`")
@Data
@EqualsAndHashCode(callSuper = false)
public class DecompressionBaseCamp implements Serializable {

    //DecompressionBaseCamp编号
    @TableId(value = "decompression_base_camp_id", type = IdType.AUTO)
    private Integer decompression_base_camp_id;
    // 减压标题
    @TableField(value = "`decompression_title`")
    private String decompression_title;
    // 咨询师姓名
    @TableField(value = "`consultant_name`")
    private String consultant_name;
    // 减压封面
    @TableField(value = "`decompression_cover`")
    private String decompression_cover;
    // 咨询师用户
    @TableField(value = "`consultant_user`")
    private Integer consultant_user;
    // 减压音频
    @TableField(value = "`decompression_audio`")
    private String decompression_audio;
    // 减压内容
    @TableField(value = "`decompression_content`")
    private String decompression_content;
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
