package com.jf.xuan.api.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

/**
 * <p>Description: 结果集对象 .</p>
 * <p>Copyright: Copyright(c) 2020.</p>
 * <p>Company: Sefonsoft.</p>
 * <p>CreateTime: 2018/12/3.</p>
 *
 * @author Junfeng
 */
@Data
@AllArgsConstructor
@JsonAutoDetect(creatorVisibility = NONE, fieldVisibility = NONE, getterVisibility = NONE, setterVisibility = NONE, isGetterVisibility = NONE)
public class ResponseResult {
    /**
     * true
     */
    public static final Integer TRUE = 0;
    /**
     * false
     */
    public static final Integer FALSE = -1;
    /**
     * flag
     */
    @JsonProperty("result")
    private Integer result;
    /**
     * msg
     */
    @JsonProperty("msg")
    private String msg;
    /**
     * data
     */
    @JsonProperty("data")
    private Object data;

    public ResponseResult(boolean result) {
        if (result) {
            new ResponseResult(TRUE, "SUCCESS");
        } else {
            throw new RuntimeException("Cannot use this constructor!");
        }
    }

    public ResponseResult(Object data) {
        this.result = TRUE;
        this.msg = "success";
        this.data = data;
    }

    public ResponseResult(Integer result, String msg) {
        this.result = result;
        this.msg = msg;
    }


}
