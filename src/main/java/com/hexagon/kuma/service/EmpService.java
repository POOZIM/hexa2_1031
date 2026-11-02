package com.hexagon.kuma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexagon.kuma.domain.Emp;
import com.hexagon.kuma.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpService {

	private final EmpMapper empMapper;
	
	//사원 전체 조회
	public List<Emp> findAll(){
		return empMapper.findAll();
	}
	
	//사원 상세 조회
	public Emp findById(int empId) {
		return empMapper.findById(empId);
	}
}
