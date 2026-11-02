package com.hexagon.hyunsuk.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	//내 정보 조회
	@PreAuthorize("hasAuthority('PERMISSION_MY_INFO_READ')")
	public String getEmp(int empId) {
		return "My name is "+empId;
	}
	
	//권한 부여
	@PreAuthorize("hasAuthority('PERMISSION_ROLE_ASSIGN')")
	public String addPermission() {
		return "Permission role assihned is successful";
	}
}
