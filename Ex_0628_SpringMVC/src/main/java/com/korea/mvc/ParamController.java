package com.korea.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.PersonVO;

@Controller
public class ParamController {

	public static final String VIEW_PATH = "/WEB-INF/views/person/";
	
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		return VIEW_PATH + "insert_form.jsp";
	}
	
	@RequestMapping("insert1.do")
	public String insert1(Model model ,String name, int age, String tel) {
		//insert1.do?name=홍길동&age=19&tel=1111
		
		PersonVO vo = new PersonVO();
		vo.setAge(age);
		vo.setName(name);
		vo.setTel(tel);
		
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "result.jsp";
		
	}
	
	@RequestMapping("insert2.do")
	public String insert2(Model model, PersonVO vo) {
		
		
		//파라미터로 넘어온 값을 vo에 속성이 일치하는 변수에 자동으로 추가해준다
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "result.jsp";
		
		//insert2 (Model moder, PersonVO vo, String name) PersonVO에 String name이 존재
		//위와 같이 vo에 이미 존재하는 변수명과 같은 이름의 파라미터를 또 받으면 오류
	}
}
