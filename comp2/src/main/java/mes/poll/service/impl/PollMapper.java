package mes.poll.service.impl;

import java.util.List;

import mes.poll.service.PollVO;
import mes.poll.service.PollDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : PollMapper.java
 * @Description : Poll Mapper Class
 * @Modification Information
 *
 * @author kym
 * @since 2021-06-18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("pollMapper")
public interface PollMapper {

	/**
	 * POLL을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PollVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertPoll(PollVO vo) throws Exception;

    /**
	 * POLL을 수정한다.
	 * @param vo - 수정할 정보가 담긴 PollVO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePoll(PollVO vo) throws Exception;

    /**
	 * POLL을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 PollVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePoll(PollVO vo) throws Exception;

    /**
	 * POLL을 조회한다.
	 * @param vo - 조회할 정보가 담긴 PollVO
	 * @return 조회한 POLL
	 * @exception Exception
	 */
    public PollVO selectPoll(PollVO vo) throws Exception;

    /**
	 * POLL 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return POLL 목록
	 * @exception Exception
	 */
    public List<?> selectPollList(PollDefaultVO searchVO) throws Exception;

    /**
	 * POLL 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return POLL 총 갯수
	 * @exception
	 */
    public int selectPollListTotCnt(PollDefaultVO searchVO);

}
