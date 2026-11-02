package com.hexagon.ssangwoo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hexagon.ssangwoo.service.SalaryService;

@Controller
public class SalaryController {

    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    // 인사 관리자용 급여 목록 화면
    @PreAuthorize("hasRole('HR_ADMIN')")
    @GetMapping("/salary/list")
    public String list(Model model) {

        model.addAttribute(
            "salaries",
            salaryService.getSalaryList()
        );

        return "salary/list";
    }
}