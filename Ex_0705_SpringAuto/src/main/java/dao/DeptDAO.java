package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.DeptVO;

//Repository 어노테이션은 Component 어노테이션의 자식이므로
//언언해두면 추후 Auto-Detecting(자동생성)이 가능해진다.
	@Repository("dept_dao")
	public class DeptDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public DeptDAO() {
		System.out.println("---DeptDAO의 생성자----");
	}
	
	public List<DeptVO> selectList(){
		List<DeptVO> list = sqlSession.selectList("dept.dept_list");
		return list;
	}
}
