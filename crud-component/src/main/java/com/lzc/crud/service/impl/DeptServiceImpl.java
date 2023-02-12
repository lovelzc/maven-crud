package com.lzc.crud.service.impl;

import com.lzc.crud.entity.Dept;
import com.lzc.crud.mapper.DeptMapper;
import com.lzc.crud.service.api.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getAllDepts() {
        return deptMapper.selectByExample(null);
    }
}
