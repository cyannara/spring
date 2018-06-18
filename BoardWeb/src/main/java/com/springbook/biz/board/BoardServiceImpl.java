package com.springbook.biz.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardServlce")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDAOSpring dao; //IoC + DI
	
	public List<BoardVO> getBoardList2() {
		System.out.println("board service list===");
		return dao.getBoardList2();
	}
	
	public List<Map<String, Object>> getBoardList() {
		System.out.println("board service list===");
		return dao.getBoardList();
	}
	public BoardVO getBoard(BoardVO vo) {
		return dao.getBoard(vo);
	}
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
	}
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
	}
	public void deleteBoard(BoardVO vo) {
		dao.deleteBoard(vo);
	}
	public void deleteBoardList(List<String> list) {
		
	}
}
