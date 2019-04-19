package com.atguigu.cache;

import com.atguigu.cache.entity.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object,Employee> employeeRedisTemplate;

    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.get(1);
        System.out.println(employee);
    }

    @Test
    public void test1() {
        stringRedisTemplate.opsForValue().append("msg","hello");
    }

    @Test
    public void test2() {
        Employee employee = employeeMapper.get(1);
//        redisTemplate.opsForValue().set("emp-01",employee);
//        Employee o = (Employee)redisTemplate.opsForValue().get("emp-01");
//        System.out.println(employee);

        employeeRedisTemplate.opsForValue().set("emp-01",employee);
    }

}
