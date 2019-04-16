package com.atguigu.cache.service.impl;

import com.atguigu.cache.entity.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import com.atguigu.cache.service.EmployeeService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author linchong
 * @create 2019-04-16 14:14
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 几个属性：
     *      *      cacheNames/value：指定缓存组件的名字;将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存；
     *      *
     *      *      key：缓存数据使用的key；可以用它来指定。默认是使用方法参数的值  1-方法的返回值
     *      *              编写SpEL； #i d;参数id的值   #a0  #p0  #root.args[0]
     *      *              getEmp[2]
     *      *
     *      *      keyGenerator：key的生成器；可以自己指定key的生成器的组件id
     *      *              key/keyGenerator：二选一使用;
     *                  例如：key = "#root.methodName+'['+#id+']'"
     *
     *      *
     *      *
     *      *      cacheManager：指定缓存管理器；或者cacheResolver指定获取解析器
     *      *
     *      *      condition：指定符合条件的情况下才缓存；
     *      *              ,condition = "#id>0"
     *      *          condition = "#a0>1"：第一个参数的值》1的时候才进行缓存
     *      *
     *      *      unless:否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *      *              unless = "#result == null"
     *      *              unless = "#a0==2":如果第一个参数的值是2，结果不缓存；
     *      *      sync：是否使用异步模式
     * @param id
     * @return
     */
    @Override
    @Cacheable(cacheNames = "emp")
    public Employee get(Integer id) {
        System.out.println("查询"+id+"号员工");
        return employeeMapper.get(id);
    }


    /**注意：查询和更新的key应该是相同的，否则更新的数据查询不到，因为key不相同
     *        key = "#employee.id":使用传入的参数的员工id；
     *        key = "#result.id"：使用返回后的id
     * @param employee
     * @return
     */
    @Override
    @CachePut(value = "emp",key = "#result.id")
    public Employee update(Employee employee) {
        System.out.println("要更新的数据："+employee);
        employeeMapper.update(employee);
        return employee;
    }

    /**
     * allEntries : true则删除所有的key,默认是false
     * beforeInvocation : true则在方法执行之前清空缓存，默认是false
     * @param id
     * @return
     */
    @Override
    @CacheEvict(value = "emp",beforeInvocation = true,allEntries = true)
    public Integer delete(Integer id) {
        int i = 1 / 0;
        System.out.println("模拟删除了："+id);
//        employeeMapper.delete(id);
        return 1;
    }
}
