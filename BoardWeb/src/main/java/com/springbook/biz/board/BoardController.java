package com.springbook.biz.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	@Autowired BoardService boardService;  //IoC, DI
	
	//목록
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model) {		
		//Service
		List<Map<String, Object>> list = boardService.getBoardList();
		model.addAttribute("list", list);
		return "/board/getBoardList";
	}
	
	//등록폼
	@RequestMapping("/boardInsertForm")
	public String BoardInsertForm() {
		return "/board/boardInsert";
	}	
	//등록처리
	@RequestMapping("/boardInsert")
	public String BoardInsert(BoardVO vo) {
		System.out.println(vo);
		return "redirect:/getBoardList";
	}
	
}
