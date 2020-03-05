package com.jf.xuan.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Map;

/**
 * JSON 工具类
 *
 * @author Junfeng
 */
public class JsonUtil {

    /**
     * 对象转换为map, 使用fastjson来转换
     *
     * @param obj obj
     * @return map
     */
    public static Map<String, Object> objToMap(Object obj) {
        String jsonString = JSON.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteMapNullValue);
        return JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>() {
        }.getType());
    }

}
