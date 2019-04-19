package com.atguigu.cache.mapper;

import com.atguigu.cache.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author linchong
 * @create 2019-04-09 17:50
 */
@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id = #{id}")
    Employee get(Integer id);

    @Update("update employee set lastName = #{lastName},email=#{email},gender=#{gender} where id = #{id}")
    Integer update(Employee employee);

    @Delete("delete from employee where id = #{id}")
    Integer delete(Integer id);

    @Select("select * from employee where lastName = #{lastName}")
    Employee getEmpByLastName(String lastName);
}
