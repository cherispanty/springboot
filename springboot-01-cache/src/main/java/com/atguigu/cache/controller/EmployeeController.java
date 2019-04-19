package com.atguigu.cache.controller;

import com.atguigu.cache.entity.Employee;
import com.atguigu.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author linchong
 * @create 2019-04-16 14:15
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get/{id}")
    @ResponseBody
    public Employee get(@PathVariable("id") Integer id) {
        return employeeService.get(id);
    }


    @GetMapping("/update")
    @ResponseBody
    public Employee update(Employee employee) {
        employeeService.update(employee);
        return employee;
    }

    @GetMapping("/delete")
    @ResponseBody
    public String delete(Integer id) {
        Integer rows = employeeService.delete(id);
        if(rows > 0) {
            return "success";
        }else {
            return "fail";
        }
    }

    @GetMapping("/emp/lastname/{lastName}")
    @ResponseBody
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName) {
            return employeeService.getEmpByLastName(lastName);
    }
}
