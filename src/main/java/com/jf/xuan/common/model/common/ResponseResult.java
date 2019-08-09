package com.jf.xuan.common.model.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonAutoDetect(creatorVisibility = NONE, fieldVisibility = NONE, getterVisibility = NONE, setterVisibility = NONE, isGetterVisibility = NONE)
public class ResponseResult {

    /**
     * TRUE
     */
    public static final Integer TRUE = 0;
    /**
     * FALSE
     */
    public static final Integer FALSE = -1;
    /**
     * flag
     */
    @JsonProperty("code")
    private Integer code;
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

    public ResponseResult(Object data) {
        this.data = data;
        this.code = 0;
        this.msg = "SUCCESS";
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
