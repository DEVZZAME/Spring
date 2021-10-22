package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVO;

public class DeptDAO {

	SqlSession sqlSession;
	
	public DeptDAO( SqlSession sqlSession ) {
		this.sqlSession = sqlSession;
		System.out.println("DAO생성자");
	}
	
	//부서목록 조회
	public List<DeptVO> selectDept(){
		
		//SqlSession sqlSession = factory.openSession(); 할 필요가 없다
		//이미 sqlSessionBean이 ref="factoryBean"을 참조하고 있기 때문에 언제든지 factory를 가져다 쓸 수 있다
		List<DeptVO> list = sqlSession.selectList("dept.dept_list");
		return list;
		
	}
}
