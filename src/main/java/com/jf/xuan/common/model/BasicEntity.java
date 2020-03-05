package com.jf.xuan.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * BasicEntity
 *
 * @author Junfeng
 */
@Data
public class BasicEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 当前第几页
     */
    @Transient
    private Integer page = 1;

    /**
     * 每页大小
     */
    @Transient
    private Integer limit = 10;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * 更新时间
     */
    @Column(name = "UPDATE_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

}
