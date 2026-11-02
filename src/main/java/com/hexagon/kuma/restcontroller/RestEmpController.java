package com.hexagon.kuma.restcontroller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hexagon.kuma.domain.Emp;
import com.hexagon.kuma.service.EmpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RestEmpController {

	private final EmpService empService;
	
	//사원 전체 조회
	@GetMapping("/api/employees")
	public List<Emp> findAll(){

		return empService.findAll();
	}

	//사원 상세 조회
	@GetMapping("/api/employees/{empId}")
	public ResponseEntity<Emp> findById(@PathVariable int empId){
		
		Emp emp = empService.findById(empId);
		
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(emp);
	}
}
