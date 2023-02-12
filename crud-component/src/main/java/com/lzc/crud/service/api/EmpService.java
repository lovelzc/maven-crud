package com.lzc.crud.service.api;

import com.github.pagehelper.PageInfo;
import com.lzc.crud.entity.Emp;

import java.util.List;

public interface EmpService {
    PageInfo getEmpByPage(Integer page);

    Integer addEmp(Emp emp);

    Boolean identifyEmpName(String name);

    Emp getEmp(Integer id);

    void updateEmp(Emp emp);

    void deleteEmp(Integer id);

    void deleteEmpForPatch(List<Integer> ids_int);
}
