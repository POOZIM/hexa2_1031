package com.hexagon.joo.restcontroller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexagon.joo.department.service.DepartmentService;
import com.hexagon.joo.dto.DepartmentDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RestDepartmentController {

	private final DepartmentService departmentService;
	
	@PostMapping("/api/departments")
	@ResponseBody
	public String regist(DepartmentDTO departmentDTO) {
		
		departmentService.regist(departmentDTO);
		return "success registing dept";
	}
	
	@GetMapping("/api/departments")
	public String getList(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_OK);
		return null;
	}
	
}