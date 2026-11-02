package com.hexagon.hyunsuk.rest.controller;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hexagon.hyunsuk.service.TestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RestLoginController {
	private final TestService testService;
	
	//나의 정보 처리 요청
	@GetMapping("/api/emps/{empId}")
	public String getMtInfo(@PathVariable("empId") int empId) {
		return testService.getEmp(empId);
	}
	
	//권한 부여 요청 처리
	@GetMapping("/api/auth")
	public String addAuth() {
		return testService.addPermission();
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public String handle(AccessDeniedException e, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setContentType("application/json; carset=UTF-8");
		
		StringBuffer data = new StringBuffer();

		data.append("{");
		data.append("      \"success\" : false,");
		data.append("      \"message\": \"권한이 없습니다\",");
		data.append("      \"data\" : null");
		data.append("}");
		
		return data.toString();
	}
}
