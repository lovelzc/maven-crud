package com.lzc.crud.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzc.crud.entity.Emp;
import com.lzc.crud.entity.EmpExample;
import com.lzc.crud.mapper.EmpMapper;
import com.lzc.crud.service.api.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageInfo<Emp> getEmpByPage(Integer page) {
        PageHelper.startPage(page,6);
        List<Emp> emps = empMapper.selectByExampleWithDept(null);
        PageInfo<Emp>pageInfo = new PageInfo<>(emps);
        return pageInfo;
    }

    @Override
    public Integer addEmp(Emp emp) {
        empMapper.insertSelective(emp);
        return 1;
    }

    @Override
    public Boolean identifyEmpName(String name) {
        EmpExample ex = new EmpExample();
        ex.createCriteria().andEmpNameEqualTo(name);
        List<Emp> emps = empMapper.selectByExample(ex);
        return emps.size()==0;
    }

    @Override
    public Emp getEmp(Integer id) {
        return empMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateEmp(Emp emp) {
        empMapper.updateByPrimaryKeySelective(emp);
    }

    @Override
    public void deleteEmp(Integer id) {
        empMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteEmpForPatch(List<Integer> ids_int) {
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpIdIn(ids_int);
        empMapper.deleteByExample(empExample);
    }


}
