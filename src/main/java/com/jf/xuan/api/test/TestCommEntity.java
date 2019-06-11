package com.jf.xuan.api.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jf.xuan.api.model.BasicEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Table;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

/**
 * <p>Description: TestCommEntity.</p>
 * <p>Copyright: Copyright(c) 2020.</p>
 * <p>Company: Sefonsoft.</p>
 * <p>CreateTime: 2018/12/3.</p>
 *
 * @author Junfeng
 * @version 1.0
 */
@Data
@Builder
@Table(name = "T_TEST")
@EqualsAndHashCode(callSuper = true)
@JsonAutoDetect(creatorVisibility = NONE, fieldVisibility = NONE, getterVisibility = NONE, setterVisibility = NONE, isGetterVisibility = NONE)
class TestCommEntity extends BasicEntity {

    /**
     * 库名
     */
    @Column(name = "NAME")
    @JsonProperty("name")
    private String name;

}