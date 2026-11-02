package com.hexagon.kuma.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hexagon.kuma.domain.Emp;

public interface EmpMapper {

	List<Emp> findAll();

	Emp findById(@Param("empId") int empId);
}
