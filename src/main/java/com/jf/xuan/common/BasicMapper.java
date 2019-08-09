package com.jf.xuan.common;

import com.jf.xuan.common.model.BasicEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper基础接口
 *
 * @author Junfeng
 * @version 1.0
 */
public interface BasicMapper<T extends BasicEntity> extends Mapper<T>, MySqlMapper<T> {
}
