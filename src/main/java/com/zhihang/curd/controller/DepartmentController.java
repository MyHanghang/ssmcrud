package com.zhihang.curd.controller;

import com.zhihang.curd.bean.Department;
import com.zhihang.curd.bean.Employee;
import com.zhihang.curd.bean.Msg;
import com.zhihang.curd.service.DepartmentService;
import com.zhihang.curd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理和部门有关的请求
 *
 * @author：xiaoHang
 * @create：2018-07-31 19:36
 **/

@Controller
public class DepartmentController{

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        //查出的所有部门信息
        List<Department> list = departmentService.getDepts();
        return Msg.success().add("depts", list);
    }
}
