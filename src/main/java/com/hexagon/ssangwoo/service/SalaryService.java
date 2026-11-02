package com.hexagon.ssangwoo.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.hexagon.ssangwoo.domain.Salary;
import com.hexagon.ssangwoo.mapper.SalaryMapper;

@Service
public class SalaryService {

    private final SalaryMapper salaryMapper;

    public SalaryService(SalaryMapper salaryMapper) {
        this.salaryMapper = salaryMapper;
    }

    // 인사 관리자용 급여 목록 조회
    @PreAuthorize("hasRole('HR_ADMIN')")
    public List<Salary> getSalaryList() {
        return salaryMapper.selectAll();
    }
}