package com.lzc.crud.controller;

import com.lzc.crud.entity.Dept;
import com.lzc.crud.service.api.DeptService;
import com.lzc.crud.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @ResponseBody
    public Result getAllDepts() {
        List<Dept> depts = deptService.getAllDepts();
        return Result.success().add("depts",depts);
    }
}
