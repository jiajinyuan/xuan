package com.jf.xuan.common;

import com.jf.xuan.api.model.BasicEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * <p>Description: 通用Mapper基础接口.</p>
 * <p>Copyright: Copyright(c) 2020.</p>
 * <p>Company: Sefonsoft.</p>
 * <p>CreateTime: 2018/12/3.</p>
 *
 * @author Junfeng
 * @version 1.0
 */
public interface BasicMapper<T extends BasicEntity> extends Mapper<T>, MySqlMapper<T> {
}
