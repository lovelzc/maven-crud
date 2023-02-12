package com.lzc.crud.controller;


import com.github.pagehelper.PageInfo;
import com.lzc.crud.entity.Emp;
import com.lzc.crud.service.api.EmpService;
import com.lzc.crud.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmpController {



    @Autowired
    private EmpService empService;

    public ModelAndView getEmp(@PathVariable(value = "page",required = false) Integer page) {
        ModelAndView mav = new ModelAndView();
        if (page == null) {
            page = 1;
        }
        PageInfo<Emp>pageInfo = empService.getEmpByPage(page);
        mav.setViewName("list");
        mav.addObject("emps",pageInfo);
        return mav;
    }

    /**
     * 实现分页信息的查看
     * @param page
     * @return
     */
    @RequestMapping(value = {"/emp/{page}"},method = RequestMethod.GET)
    @ResponseBody
    public Result getEmpWithJson(@PathVariable(value = "page", required = false) Integer page) {
        if (page == null) page = 1;
        PageInfo<Emp> pageInfo = empService.getEmpByPage(page);
        return Result.success().add("pageInfo",pageInfo);
    }

    /**
     * 实现员工的保存
     * @param emp
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    @ResponseBody
    public Result addEmp(@Valid Emp emp, BindingResult result) {

        if (result.hasErrors()) {

            Map<String,String>errors = new HashMap<>();

            List<FieldError>get = result.getFieldErrors();

            for (FieldError temp:
                 get) {
                errors.put(temp.getField(), temp.getDefaultMessage());
            }
            return Result.fail().add("errors",errors);

        } else {
            Integer get = empService.addEmp(emp);
            return Result.success()
                    .setMessage("添加用户成功");
        }

    }


    @RequestMapping(value = "/checkEmpName/{empName}",method = RequestMethod.GET)
    @ResponseBody
    public Result idEmpName(@PathVariable("empName")String empName) {

        String regName = "(^[a-zA-Z0-9_-]{6,16})|(^[\\u2E80-\\u9FFF]{2,5})";
        if (empName.matches(regName)) {
            return Result.fail("用户名格式不正确");
        }

        if (empService.identifyEmpName(empName)) {
            return Result.success();
        } else {
            return Result.fail("用户名已经存在");
        }

    }
    @RequestMapping(value = "/getEmp/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result getEmpById(@PathVariable("id")Integer id) {
        Emp emp = empService.getEmp(id);
        return Result.success().add("emp",emp);
    }

    @RequestMapping(value = "/emp/{empId}",method = RequestMethod.PUT)
    @ResponseBody
    public Result updateEmp(Emp emp) {
        empService.updateEmp(emp);
        return Result.success();
    }
    @RequestMapping(value = "/emp/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteEmp(@PathVariable("ids")String ids) {
        if (ids.contains("-")) {
            List<Integer>ids_Int = new ArrayList<>();
            String[] split = ids.split("-");
            for (String item:
                 split) {
                ids_Int.add(Integer.valueOf(item));
            }
            empService.deleteEmpForPatch(ids_Int);

        } else {
            Integer id = Integer.parseInt(ids);
            empService.deleteEmp(id);
        }

        return Result.success("删除成功");
    }
}
