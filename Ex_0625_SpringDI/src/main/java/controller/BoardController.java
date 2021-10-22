package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardServiceImpl;

//모든 컨트롤러에는 반드시 @Controller라는 어노테이션이 추가되어 있어야 한다
//어노테이션(프로그래밍 주석) : @Override처럼 JVM에게 오버라이딩 메서드임을 빠르게 캐치하게 하는 용도
//						 @Controller처럼 스프링 내부에서 특수한 클래스로서 인식하도록 처리하는 용도
@Controller
public class BoardController {
	
	public BoardController() {
		System.out.println("---boardController의 생성자---");
	}
	
	BoardServiceImpl service;
	public BoardController( BoardServiceImpl service) {
		this.service = service;
		System.out.println("--BoardController의 오버로딩 생성자--");
	}
	
	//사용자가 요청한 url을 접수
	@RequestMapping("/list.do")
	public String list(Model model) {
		//list.do매핑을 호출 받았을 때 실행되는 메서드
		System.out.println("list.do매핑 호출");
		
		List<String> list = service.select();
		model.addAttribute("list", list);//바인딩
		
		return "board_list";//포워딩
		
	}
	
}












