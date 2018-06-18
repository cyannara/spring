package com.springbook.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.ConnectionManager;
import com.springbook.biz.common.JDBCUtil;

// DAO(Data Access Object)
//@Repository("userDAO")
public class UserDAO {
    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    // SQL 명령어들
    private final String USER_GET = "select * from users where id=? and password=?";

    // CRUD 기능의 메소드 구현
    // 회원 등록
    public UserVO getUser(UserVO vo){
        UserVO user = null;
        try {
            System.out.println("===> JDBC로 getUser() 기능 처리");
            conn = ConnectionManager.connect();
            String sql ="select * from users where id=? "; 
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, vo.getId());
            rs = stmt.executeQuery();
            if(rs.next()){
                user = new UserVO();
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return user;
    }
    
    public void insertUser(UserVO vo){
    	
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
        try {
            conn = ConnectionManager.connect();
            String sql = "insert into users(id, password, name, role) values (?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            stmt.setString(3, vo.getName());
            stmt.setString(4, vo.getRole());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionManager.close(conn);
        }
    } 
    
    public List<Map<String, Object>> getUserList(){
    	List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
        try {
            conn = JDBCUtil.getConnection();  
            String sql = "select * from users";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
            	Map<String, Object> map = new HashMap<String, Object>();
                map.put("id",rs.getInt("ID"));
                map.put("password",rs.getString("password"));
                map.put("name",rs.getString("name"));
                map.put("role",rs.getString("role"));
                userList.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return userList;
    }    
}
