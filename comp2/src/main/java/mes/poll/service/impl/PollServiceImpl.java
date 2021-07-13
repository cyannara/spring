package mes.poll.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import mes.poll.service.PollDefaultVO;
import mes.poll.service.PollService;
import mes.poll.service.PollVO;
/**
 * @Class Name : PollServiceImpl.java
 * @Description : Poll Business Implement class
 * @Modification Information
 *
 * @author kym
 * @since 2021-06-18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("pollService")
public class PollServiceImpl extends EgovAbstractServiceImpl implements
        PollService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(PollServiceImpl.class);

    @Resource(name="pollMapper")
    private PollMapper pollDAO;
    
    /** ID Generation */
    //@Resource(name="{egovPollIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * POLL을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PollVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPoll(PollVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	pollDAO.insertPoll(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * POLL을 수정한다.
	 * @param vo - 수정할 정보가 담긴 PollVO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePoll(PollVO vo) throws Exception {
        pollDAO.updatePoll(vo);
    }

    /**
	 * POLL을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 PollVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePoll(PollVO vo) throws Exception {
        pollDAO.deletePoll(vo);
    }

    /**
	 * POLL을 조회한다.
	 * @param vo - 조회할 정보가 담긴 PollVO
	 * @return 조회한 POLL
	 * @exception Exception
	 */
    public PollVO selectPoll(PollVO vo) throws Exception {
        PollVO resultVO = pollDAO.selectPoll(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * POLL 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return POLL 목록
	 * @exception Exception
	 */
    public List<?> selectPollList(PollDefaultVO searchVO) throws Exception {
        return pollDAO.selectPollList(searchVO);
    }

    /**
	 * POLL 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return POLL 총 갯수
	 * @exception
	 */
    public int selectPollListTotCnt(PollDefaultVO searchVO) {
		return pollDAO.selectPollListTotCnt(searchVO);
	}
    
}
