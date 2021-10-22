package com.korea.vs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.VisitDAO;
import util.MyCommon;
import vo.VisitVO;

@Controller
public class VisitController {
	
	@Autowired//HttpServletRequest 객체를 spring이 자동으로 생성해준다!
	HttpServletRequest request;//@Autowired어노테이션으로 인해 request객체는 null이 아니다
	
	@Autowired//현재 프로젝트의 정보를 담고 있는 ServletContext객체를 자동생성
	ServletContext application;
	
	VisitDAO visit_dao;

	public void setVisit_dao(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}

	// 방명록 조회
	@RequestMapping(value = { "/", "/list.do" })
	public String list(Model model) {
		List<VisitVO> list = visit_dao.selectList();
		model.addAttribute("list", list);
		return MyCommon.Visit.VIEW_PATH + "visit_list.jsp";

	}

	// 새 글 쓰기 폼
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		return MyCommon.Visit.VIEW_PATH + "visit_insert_form.jsp";
	}

	// 새 글 등록
	@RequestMapping("/insert.do")
	public String insert(VisitVO vo) {

		vo.setIp(request.getRemoteAddr());
		
		//상대경로를 통해 실제 클라이언트가 업로드할 데이터가 저장될 절대경로를 구한다
		String webPath = "/resources/upload/"; //상대경로
		String savePath = application.getRealPath(webPath);//절대경로
		System.out.println(savePath);
		
		//업로드 될 파일의 정보
		MultipartFile photo = vo.getPhoto();
		
		String filename = "no_file";
		
		//
		if( !photo.isEmpty()) {
			filename = photo.getOriginalFilename();
			
			//절대경로에 파일 저장
			File saveFile = new File(savePath, filename);
			
			if( !saveFile.exists()) {
				saveFile.mkdirs();//절대경로 생성
			}else {
				//동일한 파일명을 가진 경로가 있다면 else로 진입
				//동일한 파일명의 이미지를 업로드 하면 안되므로 이름을 바꿔 중복을 방지해주자!!
				long time = System.currentTimeMillis();//자바 내부에서 시간을 계산해주는 코드
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
				
			}
			
			try {
				//업로드 될 파일은 MultipartResolver 객체가 지정해둔 임시저장소에 있는데
				//임시저장소의 파일은 일정 시간이 지나면 사라지기 때문에, 이를
				//개발자가 지정해둔 절대경로(saveFile)에 물리적으로 복사를 해줘야 한다.
				//이 역할을 transferTo가 해준다.
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		vo.setFilename(filename);
		visit_dao.insert(vo);

		// response.sendRedirect("list.do");
		return "redirect:list.do";
	}

	// 게시글 삭제
	@RequestMapping("/delete.do")
	@ResponseBody // Ajax를 통해 호출된 메서드는 반드시 @ResponseBody를 가지고 있어야 한다
	// return값을 콜백메서드로 전달하는 기능
	public String delete(int idx) {

		int res = visit_dao.delete(idx);

		String result = "[{'res':'no'}]";
		if (res == 1) {// 삭제성공시
			result = "[{'res':'yes'}]";
		}

		return result;

	}

	// 글 수정
	@RequestMapping("modify_form.do")
	public String modify(Model model, int idx) {

		// idx에 해당되는 게시물 정보 한 건 얻어오기
		VisitVO vo = visit_dao.selectOne(idx); // selectList 일경우 List로 묶어서 받지만 selectOne의 경우 한개만 가져오면 되기에 VO로 받는다.

		// idx에 해당되는 게시물을 정상적으로 가지고 왔다면
		// vo는 null이 아닐 것
		if (vo != null) {
			model.addAttribute("vo", vo);
		}

		return MyCommon.Visit.VIEW_PATH + "visit_modify_form.jsp";
	}

	// 글수정
	@RequestMapping("/modify.do")
	@ResponseBody // return값을 xxx.jsp의 형태
	public String modify(VisitVO vo) {

		String ip = request.getRemoteAddr();// ip
		vo.setIp(ip);

		int res = visit_dao.update(vo);

		String result = "no";
		if (res == 1) {// 삭제성공시
			result = "yes";
		}
		//콜백메서드로 result 전달
		return result;

	}
}
