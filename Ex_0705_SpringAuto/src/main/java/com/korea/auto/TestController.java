package com.korea.auto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller
public class TestController {
	
	@Autowired
	DeptDAO dept_dao;
	
	public TestController() {
	System.out.println("--TestController의 생성자--");
	}
	
	@RequestMapping(value= {"/", "/list.do"})
	public String dept_list(Model model) {
		
		List<DeptVO> list = dept_dao.selectList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/total_list.jsp"; 
		
	}
}
