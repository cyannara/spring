package com.springbook.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAOSpring {
	
	@Autowired JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO vo){
		System.out.println("===> spring jdbc insertBoard 기능 처리");
		String sql = "insert into board(seq, title, writer, content, cnt)"
				  + " values(?,?,?,?,0)";
		jdbcTemplate.update(sql, vo.getSeq(), vo.getTitle(),vo.getWriter(),vo.getContent());
	}	
	public void updateBoard(BoardVO vo){	}	
	public void deleteBoard(BoardVO vo){	}
	
	public BoardVO getBoard(BoardVO vo){
		System.out.println("===> spring jdbc getBoard() 기능 처리");
		String sql = "select * from board where seq=?";
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(sql, args, 
				                            new BoardRowMapper());
	}	
	public List<Map<String, Object>> getBoardList(){
		String sql = "select * from board order by seq desc";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<BoardVO> getBoardList2(){
		String sql = "select * from board order by seq desc";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
}

class BoardRowMapper implements RowMapper<BoardVO> {
	@Override
	public BoardVO mapRow(ResultSet rs, int arg1) throws SQLException {
		BoardVO board = new BoardVO();
        board.setSeq(rs.getInt("SEQ"));
        board.setTitle(rs.getString("TITLE"));
        board.setWriter(rs.getString("WRITER"));
        board.setContent(rs.getString("CONTENT"));
        board.setRegDate(rs.getDate("REGDATE"));
        board.setCnt(rs.getInt("CNT"));
		return board;
	}
}

