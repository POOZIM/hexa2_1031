package com.hexagon.kuma.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagon.kuma.domain.Emp;
import com.hexagon.kuma.service.EmpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RestEmpController {

	private final EmpService empService;
	
	//사원 전체 조회
	@GetMapping("/rest/employees")
	public List<Emp> findAll(){
        System.out.println("★★★ REST 사원 조회 실행 ★★★");


		return empService.findAll();
	}
	
}
