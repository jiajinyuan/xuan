package com.jf.xuan.api.demo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jf.xuan.common.model.BasicEntity;
import lombok.*;
import lombok.experimental.Accessors;


/**
 * @author Junfeng
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "T_TEST")
public class DemoCommEntity extends BasicEntity {

    /**
     * 库名
     */
    @TableField(value = "NAME")
    private String name;

}