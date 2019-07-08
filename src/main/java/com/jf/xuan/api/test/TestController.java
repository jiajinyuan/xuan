package com.jf.xuan.api.test;

import com.jf.xuan.api.common.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService service;
    @Autowired
    TestCommonService commonService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Object getAll(TestVo city) {
        return service.getCity(city);
    }

    @RequestMapping(value = "/getCommonAll", method = RequestMethod.GET)
    public ResponseResult getCommonAll(TestCommEntity entity) {
        return commonService.getCommonAll(entity);
    }

    @Cacheable(value = "test", key = "#id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseResult get(@PathVariable Long id) {
        return commonService.get(id);
    }

    @CachePut(value = "test", key = "#entity.id")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseResult add(TestCommEntity entity) {
        return commonService.add(entity);
    }

    @CachePut(value = "test", key = "#entity.id")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseResult update(TestCommEntity entity) {
        return commonService.update(entity);
    }

    @CacheEvict(value = "test", key = "#id")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable Long id) {
        return commonService.delete(id);
    }


}
