package com.jf.xuan.api.demo.mapper;

import com.jf.xuan.api.demo.model.DemoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Junfeng
 */
@Repository
@Mapper
public interface DemoMapper {

    List<DemoVo> getCity(DemoVo city);
}
