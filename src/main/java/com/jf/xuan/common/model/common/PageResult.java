package com.jf.xuan.common.model.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: 分页结果 .</p>
 * <p>Copyright: Copyright(c) 2020.</p>
 * <p>Company: Sefonsoft.</p>
 * <p>CreateTime: 2018/12/3.</p>
 *
 * @author Junfeng
 */
@Data
@EqualsAndHashCode
@ToString
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -201527455474861313L;
    /**
     * the number of all data
     */
    private Long total;
    /**
     * the number of rows per page
     */
    private Integer limit;
    /**
     * data
     */
    private List<T> list;

    public PageResult(List<T> list, long total, Integer limit) {
        this.list = list;
        this.total = total;
        this.limit = limit;
    }
}