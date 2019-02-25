package com.jf.xuan.api.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestMapper mapper;

    public List<TestVo> getCity(TestVo city) {
        return mapper.getCity(city);
    }


}
