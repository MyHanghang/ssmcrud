package com.zhihang.curd.test;


import com.zhihang.curd.bean.Department;
import com.zhihang.curd.bean.Employee;
import com.zhihang.curd.dao.DepartmentMapper;
import com.zhihang.curd.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao的工作
 * 推荐Spring的项目可以用Spring的单元测试，可以自动注入我们需要的组件
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 * 3、autowired注入
 *
 * @author：xiaoHang
 * @create：2018-07-28 21:16
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest{

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    /**
     * 测试departmentMapper
     */
    @Test
    public void testCRUD(){
        //        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
        System.out.println(departmentMapper);
        //1、插入几个部门
        //        Department department = new Department(null, "营销部");
        //        //        Department department2 = new Department(null, "营销部");
        //        //        departmentMapper.insertSelective(department);
        //        //        departmentMapper.insertSelective(department2);
        //employeeMapper.insertSelective(new Employee(10, "jack", "m", "111@qq.com", 1));

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++){
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            employeeMapper.insertSelective(new Employee(null, uid, "m", uid + "@qq.com", 1));
        }
        System.out.println("批量完成！！！");
    }
}
