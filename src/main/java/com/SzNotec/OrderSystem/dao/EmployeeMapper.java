package com.SzNotec.OrderSystem.dao;

import com.SzNotec.OrderSystem.entity.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer empsno);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer empsno);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}