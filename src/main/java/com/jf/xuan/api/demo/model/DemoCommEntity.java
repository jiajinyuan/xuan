package com.jf.xuan.api.demo.model;

import com.jf.xuan.common.model.BasicEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author Junfeng
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_TEST")
public class DemoCommEntity extends BasicEntity {

    /**
     * 库名
     */
    @Column(name = "NAME")
    private String name;

}