package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.service.*;
import com.sist.web.vo.*;

@Controller
public class EmpController {
	@Autowired
	private EmpService service;
	
	@GetMapping("/emp/list")
	public String emp_list(Model model) {
		List<EmpVO> list=service.empListData();
		model.addAttribute("list",list);
		return "/emp/list";
	}
}
