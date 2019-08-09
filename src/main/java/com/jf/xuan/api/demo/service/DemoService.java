package com.jf.xuan.api.demo.service;

import com.jf.xuan.api.demo.model.DemoVo;

import java.util.List;


/**
 * @author Junfeng
 */
public interface DemoService {

    /**
     * SERVICE ID
     */
    String SERVICE_ID = "demo.demoService";

    /**
     * 查询
     *
     * @param city city
     * @return List<DemoVo>
     * @author Junfeng
     */
    List<DemoVo> getCity(DemoVo city);
}
