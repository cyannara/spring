package com.company.app.board.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.company.app.board.BoardService;
import com.company.app.board.BoardVO;

@Controller
@SessionAttributes("board")  //모델에 board 속성이 추가된다면 session에도 추가
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(HttpServletRequest request, BoardVO vo) {
		request.setAttribute("boardList", boardService.getBoardList());
		return "board/getBoardList";
	}
	
	//수정폼
	@RequestMapping(value="/updateBoard", method=RequestMethod.GET)
	public String updateBoardForm() {
		return "board/updateBoard";
	}
	
	//수정처리
	@RequestMapping(value="/updateBoard", method=RequestMethod.POST)
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println(vo);
		//서비스 수정 처리
		//boardService.updateBoard(vo);
		return "board/getBoard";
	}
	
	//등록폼
	@RequestMapping(value="/insertBoard", method=RequestMethod.GET)
	public String insertBoardForm() {
		return "board/insertBoard";
	}	
	//등록처리
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(@ModelAttribute("vo") BoardVO vo) {
		//model.addAttrribute("boardVO",vo)
		
		//서비스 이용하여 등록처리하고 목록페이지로 이동
		boardService.insertBoard(vo);
		System.out.println(vo);
		//return "redirect:/getBoardList";
		return "board/getBoard";
	}
	
/*	@RequestMapping("/getBoard")
	public String getBoard(@RequestParam(value="s", required=false, defaultValue="1") String seq, Model model) {
		System.out.println("seq:" + seq);
		model.addAttribute("board", boardService.getBoard(seq));
		return "board/getBoard";
	}*/
	
	@RequestMapping("/getBoard/{seq}")
	public String getBoard(@PathVariable String seq,  Model model) {
		System.out.println("seq:" + seq);
		model.addAttribute("board", boardService.getBoard(seq));
		return "board/getBoard";
	}
}







