package com.korea.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 생성시에는 반드시 @Controller 어노테이션 추가
@Controller
public class TestController {
	
	//jsp를 폴더별로 관리한다는 가정하게 참조할 상수
	public static final String VIEW_PATH = "/WEB-INF/views/test/";
	
	public TestController() {
		System.out.println("--TestController의 생성자--");
	}
	
	@RequestMapping("/test.do")
	public String test() {
		
		//WEB-INF/views/test.jsp
		return VIEW_PATH + "test.jsp";//포워딩
	}
	
	@RequestMapping("/greet.do")
	public String greet( Model model) {
		
		String[] msg = {"hi", "hello", "안녕", "arigatou"};
		
		return VIEW_PATH + "greet.jsp";//포워딩
	}
}



































