package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.GogekDAO;
import vo.GogekVO;

@Controller
public class GogekController {

	GogekDAO gogek_dao;
	public GogekController(GogekDAO gogek_dao) {
		this.gogek_dao = gogek_dao;
	}
	
	@RequestMapping("list2.do")
	public String list(Model model) {
		List<GogekVO> list = gogek_dao.selectList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/gogek/gogek_list.jsp";
	}
}
