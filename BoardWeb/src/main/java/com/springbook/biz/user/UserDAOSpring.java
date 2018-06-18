package com.springbook.biz.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOSpring {
	
	@Autowired JdbcTemplate jdbcTemplate;
	
	public void insertUser(UserVO vo){
		System.out.println("===> spring jdbc insertUser 기능 처리");
		String sql = "insert into user(id, name, password, role)"
				  + " values(?,?,?,?)";
		jdbcTemplate.update(sql, vo.getId(), vo.getName(),vo.getPassword(),vo.getRole());
	}	
	public void updateUser(UserVO vo){	}	
	public void deleteUser(UserVO vo){	}
	
	public UserVO getUser(UserVO vo){
		System.out.println("===> spring jdbc getUser() 기능 처리");
		String sql = "select * from user where id=?";
		Object[] args = {vo.getId()};
		return jdbcTemplate.queryForObject(sql, args, 
				                            new UserRowMapper());
	}	
	public List<Map<String, Object>> getUserList(){
		String sql = "select * from user order by id desc";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<UserVO> getUserList2(){
		String sql = "select * from user order by id desc";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}
}

class UserRowMapper implements RowMapper<UserVO> {
	@Override
	public UserVO mapRow(ResultSet rs, int arg1) throws SQLException {
		UserVO user = new UserVO();
        user.setId(rs.getString("ID"));
        user.setName(rs.getString("NAME"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setRole(rs.getString("ROLE"));
		return user;
	}
}

