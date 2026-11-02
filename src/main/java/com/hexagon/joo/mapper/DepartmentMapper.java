package com.hexagon.joo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hexagon.joo.domain.Department;

@Mapper
public interface DepartmentMapper {
   Department select(int departmentId);
}
