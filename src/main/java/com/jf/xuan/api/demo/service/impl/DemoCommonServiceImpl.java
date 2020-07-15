package com.jf.xuan.api.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.xuan.common.model.common.PageResult;
import com.jf.xuan.api.demo.mapper.DemoCommMapper;
import com.jf.xuan.api.demo.model.DemoCommEntity;
import com.jf.xuan.api.demo.service.DemoCommonService;
import com.jf.xuan.common.model.common.ResponseResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Junfeng
 */
@Service(DemoCommonService.SERVICE_ID)
public class DemoCommonServiceImpl implements DemoCommonService {

    private final DemoCommMapper mapper;

    public DemoCommonServiceImpl(DemoCommMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ResponseResult getCommonAll(DemoCommEntity entity) {
        Page<Object> page = PageHelper.startPage(entity.getPage(), entity.getLimit());
        List<DemoCommEntity> data = mapper.selectList(null);
        return new ResponseResult(new PageResult<>(data, page.getTotal(), entity.getLimit()));
    }

    @Override
    public ResponseResult get(Long id) {
        return new ResponseResult(mapper.selectById(id));
    }

    @Override
    public ResponseResult add(DemoCommEntity entity) {
        int i = mapper.insert(entity);
        return new ResponseResult(ResponseResult.TRUE, "", i);
    }

    @Override
    public ResponseResult update(DemoCommEntity entity) {
        int i = mapper.updateById(entity);
        return new ResponseResult(ResponseResult.TRUE, "", i);
    }

    @Override
    public ResponseResult delete(Long id) {
        int i = mapper.deleteById(id);
        return new ResponseResult(ResponseResult.TRUE, "", i);
    }
}
