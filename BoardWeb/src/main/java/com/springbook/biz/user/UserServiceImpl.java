package com.springbook.biz.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAOSpring userDAO;
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}
	public void updateUser(UserVO vo) {
		userDAO.updateUser(vo);
	}
	public void deleteUser(UserVO vo) {
		userDAO.deleteUser(vo);
	}
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
	public List<Map<String, Object>> getUserList(UserVO vo) {
		return userDAO.getUserList();
	}

}
