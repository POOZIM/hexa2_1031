package com.hexagon.joo.department.service;

import org.springframework.stereotype.Service;

import com.hexagon.joo.domain.Department;
import com.hexagon.joo.dto.DepartmentDTO;
import com.hexagon.joo.mapper.DepartmentMapper;

@Service
public class DepartmentService {
	private final DepartmentMapper departmentMapper;

	public void regist(DepartmentDTO departmentDTO) {
		Department dept = new Department();
		
		departmentDTO.getDepartmentName();
		dept.setDepartmentName(departmentDTO.getDepartmentName());
			
		
	}

}
