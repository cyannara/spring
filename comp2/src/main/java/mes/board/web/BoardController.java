package mes.board.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.com.cmm.EgovWebUtil;
import egovframework.com.cmm.util.EgovResourceCloseHelper;
import egovframework.com.utl.fcc.service.EgovFormBasedFileUtil;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import mes.board.service.BoardDefaultVO;
import mes.board.service.BoardService;
import mes.board.service.BoardVO;

/**
 * @Class Name : BoardController.java
 * @Description : Board Controller class
 * @Modification Information
 *
 * @author kym
 * @since 20210621
 * @version 1.0
 * @see
 * 
 *      Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = BoardVO.class)
public class BoardController {

	@Resource(name = "testIdGnrService")
	private EgovIdGnrService idgenService;

	@Resource(name = "boardService")
	private BoardService boardService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/**
	 * BOARD 목록을 조회한다. (pageing)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 BoardDefaultVO
	 * @return "/board/BoardList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/board/BoardList.do")
	public String selectBoardList(@ModelAttribute("searchVO") BoardDefaultVO searchVO, ModelMap model)
			throws Exception {

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

		List<?> boardList = boardService.selectBoardList(searchVO);
		model.addAttribute("resultList", boardList);

		int totCnt = boardService.selectBoardListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/mes/board/BoardList";
	}


	@RequestMapping("/prod.do")
	public String prod() throws Exception {
		return "/mes/prod/jqueryModal";
	}
	
	@RequestMapping("/board/addBoardView.do")
	public String addBoardView(@ModelAttribute("searchVO") BoardDefaultVO searchVO, Model model) throws Exception {
		System.out.println(idgenService.getNextStringId() + "=============");
		model.addAttribute("boardVO", new BoardVO());
		return "/mes/board/BoardRegister";
	}

	@RequestMapping("/board/addBoard.do")
	public String addBoard(BoardVO boardVO, @ModelAttribute("searchVO") BoardDefaultVO searchVO, SessionStatus status)
			throws Exception {
		boardService.insertBoard(boardVO);
		status.setComplete();
		return "forward:/board/BoardList.do";
	}

	@RequestMapping("/board/updateBoardView.do")
	public String updateBoardView(@RequestParam("no") java.math.BigDecimal no,
			@ModelAttribute("searchVO") BoardDefaultVO searchVO, Model model) throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(no);
		// 변수명은 CoC 에 따라 boardVO
		model.addAttribute(selectBoard(boardVO, searchVO));
		return "/mes/board/BoardRegister";
	}

	@RequestMapping("/board/selectBoard.do")
	public @ModelAttribute("boardVO") BoardVO selectBoard(BoardVO boardVO,
			@ModelAttribute("searchVO") BoardDefaultVO searchVO) throws Exception {
		return boardService.selectBoard(boardVO);
	}

	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(BoardVO boardVO, @ModelAttribute("searchVO") BoardDefaultVO searchVO,
			SessionStatus status) throws Exception {
		boardService.updateBoard(boardVO);
		status.setComplete();
		return "forward:/board/BoardList.do";
	}

	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(BoardVO boardVO, @ModelAttribute("searchVO") BoardDefaultVO searchVO,
			SessionStatus status) throws Exception {
		boardService.deleteBoard(boardVO);
		status.setComplete();
		return "forward:/board/BoardList.do";
	}
	
	@RequestMapping(value = "/main/down.do")
	public void getDown(HttpServletResponse response, @RequestParam String fileName) throws Exception{
		String serverSubPath  = "e:/upload";
		String downFileName = serverSubPath + "/" + fileName;

		File file = new File(EgovWebUtil.filePathBlackList(downFileName));

		if (!file.exists()) {
			throw new FileNotFoundException(downFileName);
		}

		if (!file.isFile()) {
			throw new FileNotFoundException(downFileName);
		}

		byte[] b = new byte[8192];

		String original = fileName.replaceAll("\r", "").replaceAll("\n", "");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + original + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		BufferedInputStream fin = null;
		BufferedOutputStream outs = null;

		try {
			fin = new BufferedInputStream(new FileInputStream(file));
			outs = new BufferedOutputStream(response.getOutputStream());

			int read = 0;

			while ((read = fin.read(b)) != -1) {
				outs.write(b, 0, read);
			}
		} finally {
			EgovResourceCloseHelper.close(outs, fin);
		}
	}

	@RequestMapping(value = "/main/getByteImage.do")
	public ResponseEntity<byte[]> getByteImage(HttpServletResponse response, @RequestParam String fileName)
			throws SerialException, Exception {
		File inputFile = new File("e:/upload/",fileName);
		byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_GIF);		
		return new ResponseEntity<byte[]>(fileContent, headers, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/main/getByteImage2.do")
	@ResponseBody
	public byte[] getByteImage2(HttpServletResponse response, @RequestParam String fileName) throws IOException{
		File inputFile = new File("e:/upload/",fileName);
		byte[] fileContent = FileUtils.readFileToByteArray(inputFile);		
		return fileContent;
	}
	
	
	
	

	/*
	 * @RequestMapping(value="/getByteImage.do") public void
	 * fileToBase64StringConversion() throws IOException { // load file from
	 * /src/test/resources ClassLoader classLoader = getClass().getClassLoader();
	 * File inputFile = new File("e:/upload/mes1.png"); //new
	 * File(classLoader.getResource(inputFilePath).getFile());
	 * 
	 * byte[] fileContent = FileUtils.readFileToByteArray(inputFile); String
	 * encodedString = Base64.getEncoder().encodeToString(fileContent);
	 * 
	 * // create output file
	 * 
	 * File outputFile = new File(inputFile .getParentFile() .getAbsolutePath() +
	 * File.pathSeparator + outputFilePath);
	 * 
	 * 
	 * // decode the string and write to file
	 * 
	 * byte[] decodedBytes = Base64 .getDecoder() .decode(encodedString);
	 * 
	 * //FileUtils.writeByteArrayToFile(outputFile, decodedBytes); }
	 */
}
