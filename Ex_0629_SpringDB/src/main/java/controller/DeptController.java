package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller
public class DeptController {

	//실행경로를 지정
	public static final String VIEW_PATH = "/WEB-INF/views/dept/";
	
	DeptDAO dept_dao;
	public void setDept_dao(DeptDAO dept_dao) {
		this.dept_dao = dept_dao;
		System.out.println("컨트롤러 셋터");
	}
	
	@RequestMapping("/list.do")
	public String list( Model model ) {
		
		//DAO로부터 부서목록을 조회
		List<DeptVO> list = dept_dao.selectDept();
		
		model.addAttribute("list", list);//바인딩
		
		return VIEW_PATH + "dept_list.jsp";//포워딩
	}
}













