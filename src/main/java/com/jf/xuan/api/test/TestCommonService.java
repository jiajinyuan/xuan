package com.jf.xuan.api.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.xuan.api.common.PageResult;
import com.jf.xuan.api.common.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCommonService {

    @Autowired
    private TestCommMapper mapper;

    public ServiceResult getCommonAll(TestCommEntity entity) {

        Page<Object> page = PageHelper.startPage(entity.getPage(), entity.getLimit());
        List<TestCommEntity> data = mapper.selectAll();
        ServiceResult result = new ServiceResult(new PageResult<>(data, page.getTotal(), entity.getLimit()));
        return result;
    }

    public ServiceResult get(Long id) {
        return new ServiceResult(mapper.selectByPrimaryKey(id));
    }

    public ServiceResult add(TestCommEntity entity) {
        int i = mapper.insertSelective(entity);
        return new ServiceResult(true, "", i);
    }

    public ServiceResult update(TestCommEntity entity) {
        int i = mapper.updateByPrimaryKeySelective(entity);
        return new ServiceResult(true, "", i);
    }

    public ServiceResult delete(Long id) {
        int i = mapper.deleteByPrimaryKey(id);
        return new ServiceResult(true, "", i);
    }
}
