package mes.poll.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import mes.poll.service.PollService;
import mes.poll.service.PollDefaultVO;
import mes.poll.service.PollVO;

/**
 * @Class Name : PollController.java
 * @Description : Poll Controller class
 * @Modification Information
 *
 * @author kym
 * @since 2021-06-18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=PollVO.class)
public class PollController {

    @Resource(name = "pollService")
    private PollService pollService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * POLL 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 PollDefaultVO
	 * @return "/poll/PollList"
	 * @exception Exception
	 */
    @RequestMapping(value="/poll/PollList.do")
    public String selectPollList(@ModelAttribute("searchVO") PollDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	System.out.println("=====================");
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> pollList = pollService.selectPollList(searchVO);
        model.addAttribute("resultList", pollList);
        
        int totCnt = pollService.selectPollListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/mes/poll/PollList";
    } 
    
    @RequestMapping("/poll/addPollView.do")
    public String addPollView(
            @ModelAttribute("searchVO") PollDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("pollVO", new PollVO());
        return "/mes/poll/PollRegister";
    }
    
    @RequestMapping("/poll/addPoll.do")
    public String addPoll(
            PollVO pollVO,
            @ModelAttribute("searchVO") PollDefaultVO searchVO, SessionStatus status)
            throws Exception {
    	int i=5/0;
        pollService.insertPoll(pollVO);
        status.setComplete();
        return "forward:/poll/PollList.do";
    }
    
    @RequestMapping("/poll/updatePollView.do")
    public String updatePollView(
            @RequestParam("no") java.math.BigDecimal no ,
            @ModelAttribute("searchVO") PollDefaultVO searchVO, Model model)
            throws Exception {
        PollVO pollVO = new PollVO();
        pollVO.setNo(no);
        // 변수명은 CoC 에 따라 pollVO
        model.addAttribute(selectPoll(pollVO, searchVO));
        return "/mes/poll/PollRegister";
    }

    @RequestMapping("/poll/selectPoll.do")
    public @ModelAttribute("pollVO")
    PollVO selectPoll(
            PollVO pollVO,
            @ModelAttribute("searchVO") PollDefaultVO searchVO) throws Exception {
        return pollService.selectPoll(pollVO);
    }

    @RequestMapping("/poll/updatePoll.do")
    public String updatePoll(
            PollVO pollVO,
            @ModelAttribute("searchVO") PollDefaultVO searchVO, SessionStatus status)
            throws Exception {
        pollService.updatePoll(pollVO);
        status.setComplete();
        return "forward:/poll/PollList.do";
    }
    
    @RequestMapping("/poll/deletePoll.do")
    public String deletePoll(
            PollVO pollVO,
            @ModelAttribute("searchVO") PollDefaultVO searchVO, SessionStatus status)
            throws Exception {
        pollService.deletePoll(pollVO);
        status.setComplete();
        return "forward:/poll/PollList.do";
    }

}
