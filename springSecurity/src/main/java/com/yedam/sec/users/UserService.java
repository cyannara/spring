package com.yedam.sec.users;

public interface UserService {
    //조회
	public UserVO getUser(UserVO vo);
	//등록
	public int insertUser(UserVO vo);
}
