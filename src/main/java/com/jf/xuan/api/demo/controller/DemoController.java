package com.jf.xuan.api.demo.controller;

import com.jf.xuan.api.demo.model.DemoCommEntity;
import com.jf.xuan.api.demo.model.DemoVo;
import com.jf.xuan.api.demo.service.DemoCommonService;
import com.jf.xuan.api.demo.service.DemoService;
import com.jf.xuan.common.model.common.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;


/**
 * @author Junfeng
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    /**
     * service
     */
    @Autowired
    @Qualifier(DemoService.SERVICE_ID)
    private DemoService service;
    /**
     * commonService
     */
    @Autowired
    @Qualifier(DemoCommonService.SERVICE_ID)
    private DemoCommonService commonService;

    @GetMapping(value = "/getAll")
    public Object getAll(DemoVo city) {
        return service.getCity(city);
    }

    @GetMapping(value = "/getCommonAll")
    public ResponseResult getCommonAll(DemoCommEntity entity) {
        return commonService.getCommonAll(entity);
    }

    @Cacheable(value = "demo", key = "#id")
    @GetMapping(value = "/{id}")
    public ResponseResult get(@PathVariable Long id) {
        return commonService.get(id);
    }

    @CachePut(value = "demo", key = "#entity.id")
    @PostMapping(value = "/")
    public ResponseResult add(DemoCommEntity entity) {
        return commonService.add(entity);
    }

    @CachePut(value = "demo", key = "#entity.id")
    @PutMapping(value = "/")
    public ResponseResult update(DemoCommEntity entity) {
        return commonService.update(entity);
    }

    @CacheEvict(value = "demo", key = "#id")
    @DeleteMapping(value = "/{id}")
    public ResponseResult delete(@PathVariable Long id) {
        return commonService.delete(id);
    }
}
