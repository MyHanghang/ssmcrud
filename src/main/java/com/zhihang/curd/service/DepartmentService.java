package com.zhihang.curd.service;

import com.zhihang.curd.bean.Department;
import com.zhihang.curd.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：xiaoHang
 * @create：2018-07-31 19:37
 **/

@Service
public class DepartmentService{

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts(){
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}
