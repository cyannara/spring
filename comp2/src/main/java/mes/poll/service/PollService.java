package mes.poll.service;

import java.util.List;
import mes.poll.service.PollDefaultVO;
import mes.poll.service.PollVO;

/**
 * @Class Name : PollService.java
 * @Description : Poll Business class
 * @Modification Information
 *
 * @author kym
 * @since 2021-06-18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface PollService {
	
	/**
	 * POLL을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PollVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertPoll(PollVO vo) throws Exception;
    
    /**
	 * POLL을 수정한다.
	 * @param vo - 수정할 정보가 담긴 PollVO
	 * @return void형
	 * @exception Exception
	 */
    void updatePoll(PollVO vo) throws Exception;
    
    /**
	 * POLL을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 PollVO
	 * @return void형 
	 * @exception Exception
	 */
    void deletePoll(PollVO vo) throws Exception;
    
    /**
	 * POLL을 조회한다.
	 * @param vo - 조회할 정보가 담긴 PollVO
	 * @return 조회한 POLL
	 * @exception Exception
	 */
    PollVO selectPoll(PollVO vo) throws Exception;
    
    /**
	 * POLL 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return POLL 목록
	 * @exception Exception
	 */
    List selectPollList(PollDefaultVO searchVO) throws Exception;
    
    /**
	 * POLL 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return POLL 총 갯수
	 * @exception
	 */
    int selectPollListTotCnt(PollDefaultVO searchVO);
    
}
