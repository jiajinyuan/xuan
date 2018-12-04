package com.jf.course.api.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

/**
 * <p>Description: 分页结果 .</p>
 * <p>Copyright: Copyright(c) 2020.</p>
 * <p>Company: Sefonsoft.</p>
 * <p>CreateTime: 2018/12/3.</p>
 *
 * @author Junfeng
 */
@Data
@JsonAutoDetect(creatorVisibility = NONE, fieldVisibility = NONE, getterVisibility = NONE, setterVisibility = NONE, isGetterVisibility = NONE)
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -201527455474861313L;
    /**
     * the number of all data
     */
    @JsonProperty("total")
    private Long total;
    /**
     * the number of rows per page
     */
    @JsonProperty("limit")
    private Integer limit;
    /**
     * data
     */
    @JsonProperty("list")
    private List<T> list;

    public PageResult(List<T> list, long total, Integer limit) {
        this.list = list;
        this.total = total;
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                ", total=" + total +
                ", rows=" + limit +
                ", list=" + list +
                '}';
    }
}