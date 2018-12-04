package com.jf.course.api.test;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface TestMapper {
    List<TestVo> getCity(TestVo city);
}
