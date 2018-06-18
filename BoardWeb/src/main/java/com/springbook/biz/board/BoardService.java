package com.springbook.biz.board;

import java.util.List;
import java.util.Map;

public interface BoardService {

	//목록조회 VO
	public List<BoardVO> getBoardList2();
	
	//목록조회
	public List<Map<String,Object>> getBoardList();
	
	//단건조회
	public BoardVO getBoard(BoardVO vo);
	
	//등록
	public void insertBoard(BoardVO vo);
	
	//수정
	public void updateBoard(BoardVO vo);
	
	//단건삭제
	public void deleteBoard(BoardVO vo);
	
	//다건삭제
	public void deleteBoardList(List<String> list);
}
