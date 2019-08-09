package com.jf.xuan.api.demo.service.impl;

import com.jf.xuan.api.demo.mapper.DemoMapper;
import com.jf.xuan.api.demo.model.DemoVo;
import com.jf.xuan.api.demo.service.DemoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Junfeng
 */
@Service(DemoService.SERVICE_ID)
public class DemoServiceImpl implements DemoService {

    private final DemoMapper mapper;

    public DemoServiceImpl(DemoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<DemoVo> getCity(DemoVo city) {
        return mapper.getCity(city);
    }

}
