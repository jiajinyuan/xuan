package com.jf.xuan.api.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.xuan.api.common.PageResult;
import com.jf.xuan.api.common.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCommonService {

    @Autowired
    private TestCommMapper mapper;

    public ResponseResult getCommonAll(TestCommEntity entity) {

        Page<Object> page = PageHelper.startPage(entity.getPage(), entity.getLimit());
        List<TestCommEntity> data = mapper.selectAll();
        ResponseResult result = new ResponseResult(new PageResult<>(data, page.getTotal(), entity.getLimit()));
        return result;
    }

    public ResponseResult get(Long id) {
        return new ResponseResult(mapper.selectByPrimaryKey(id));
    }

    public ResponseResult add(TestCommEntity entity) {
        int i = mapper.insertSelective(entity);
        return new ResponseResult(ResponseResult.TRUE, "", i);
    }

    public ResponseResult update(TestCommEntity entity) {
        int i = mapper.updateByPrimaryKeySelective(entity);
        return new ResponseResult(ResponseResult.TRUE, "", i);
    }

    public ResponseResult delete(Long id) {
        int i = mapper.deleteByPrimaryKey(id);
        return new ResponseResult(ResponseResult.TRUE, "", i);
    }
}
