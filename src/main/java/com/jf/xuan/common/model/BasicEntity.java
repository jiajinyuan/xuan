package com.jf.xuan.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * BasicEntity
 *
 * @author Junfeng
 */
@Data
public class BasicEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    protected Long id;
    /**
     * 当前第几页
     */
    @TableField(exist = false)
    protected Integer page = 1;

    /**
     * 每页大小
     */
    @TableField(exist = false)
    protected Integer limit = 10;

    /**
     * 每页大小
     */
    @TableField(exist = false)
    protected String searchKey;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("CREATE_DATE")
    protected LocalDateTime createDate;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("UPDATE_DATE")
    protected LocalDateTime updateDate;

}
