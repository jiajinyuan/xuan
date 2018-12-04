package com.jf.course.api.common;

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
public class ServiceResult {
    /**
     * flag
     */
    @JsonProperty("result")
    private boolean result;
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

    public ServiceResult(boolean result) {
        if (result) {
            new ServiceResult(true, "SUCCESS");
        } else {
            throw new RuntimeException("Cannot use this constructor!");
        }
    }

    public ServiceResult(Object data) {
        this.result = true;
        this.msg = "success";
        this.data = data;
    }

    public ServiceResult(boolean result, String msg) {
        this.result = result;
        this.msg = msg;
    }


}
