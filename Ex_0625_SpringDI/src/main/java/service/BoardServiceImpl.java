package service;

import java.util.List;

import dao.BoardDAOImpl;



public class BoardServiceImpl implements BoardService{
	
	BoardDAOImpl dao;
	
	public BoardServiceImpl(BoardDAOImpl dao) {
		this.dao = dao;
	}
	
	@Override
	public List select() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

}
