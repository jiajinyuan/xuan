package com.jf.xuan.common.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页此参数
 *
 * @author Junfeng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParam {

    /**
     * the number of page
     */
    private int page = 0;

    /**
     * the number of rows per page
     */
    private int limit = 10;

    public int offset() {
        if (page > 0) {
            return (page - 1) * limit;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "PageParam{page="
                + page
                + ", limit="
                + limit
                + "}";
    }
}
