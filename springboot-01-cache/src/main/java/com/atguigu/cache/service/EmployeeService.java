package com.atguigu.cache.service;

import com.atguigu.cache.entity.Employee;

/**
 * @author linchong
 * @create 2019-04-16 14:14
 */
public interface EmployeeService {
    Employee get(Integer id);
    Employee update(Employee employee);
    Integer delete(Integer id);
    Employee getEmpByLastName(String lastName);
}
