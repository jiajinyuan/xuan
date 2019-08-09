package com.jf.xuan.api.demo.service;

import com.jf.xuan.api.demo.model.DemoCommEntity;
import com.jf.xuan.common.model.common.ResponseResult;

/**
 * @author Junfeng
 */
public interface DemoCommonService {

    /**
     * SERVICE ID
     */
    String SERVICE_ID = "demo.testCommonService";

    /**
     * 分页查询
     *
     * @param entity entity
     * @return ResponseResult
     * @author Junfeng
     */
    ResponseResult getCommonAll(DemoCommEntity entity);

    /**
     * 根据id获取
     *
     * @param id id
     * @return ResponseResult
     * @author Junfeng
     */
    ResponseResult get(Long id);

    /**
     * 添加
     *
     * @param entity entity
     * @return ResponseResult
     * @author Junfeng
     */
    ResponseResult add(DemoCommEntity entity);

    /**
     * 更新
     *
     * @param entity entity
     * @return ResponseResult
     * @author Junfeng
     */
    ResponseResult update(DemoCommEntity entity);

    /**
     * 删除
     *
     * @param id id
     * @return ResponseResult
     * @author Junfeng
     */
    ResponseResult delete(Long id);
}
