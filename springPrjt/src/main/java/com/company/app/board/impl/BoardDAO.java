package com.company.app.board.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.app.board.BoardSearchVO;
import com.company.app.board.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	// 목록조회
	public List<Map<String, Object>> getBoardList(BoardSearchVO vo) {
		return mybatis.selectList("com.yedam.web.board.BoardDAO.getBoardList", vo);
	};
	
	//전체레코드 건수 조회
	public int getCount(BoardSearchVO vo) {
		return mybatis.selectOne("com.yedam.web.board.BoardDAO.getCount", vo);
	};

		public List<BoardVO> getBoardList2(BoardVO vo) {
			System.out.println(vo);
			return mybatis.selectList("com.yedam.web.board.BoardDAO.getBoardList2", vo);
		};

		// 단건저회
		public BoardVO getBoard(String seqs) {
			return mybatis.selectOne("com.yedam.web.board.BoardDAO.getBoard", seqs);
		}

		// 입력
		public void insertBoard(BoardVO vo) {
			mybatis.insert("com.yedam.web.board.BoardDAO.insertBoard", vo);
		}

		// 수정
		public void updateBoard(BoardVO vo) {
			mybatis.update("com.yedam.web.board.BoardDAO.updateBoard", vo);
		}

		// 삭제
		public void deleteBoard(String seqs) {
			mybatis.delete("com.yedam.web.board.BoardDAO.deleteBoard", seqs);
		}

		
}
