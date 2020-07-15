package com.jf.xuan.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * BasicEntity
 *
 * @author Junfeng
 */
@Data
public class BasicEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 当前第几页
     */
    @TableField(exist = false)
    private Integer page = 1;

    /**
     * 每页大小
     */
    @TableField(exist = false)
    private Integer limit = 10;
    /**
     * 创建时间
     */
    @TableField(value = "CREATE_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

}
