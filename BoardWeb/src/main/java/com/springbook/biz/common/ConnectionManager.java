package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {
	public static Connection connect() {
		Connection conn = null;
		try {
			//연결 URL, 드라이버명
			String jdbc_driver = "oracle.jdbc.OracleDriver";
			String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
			//1.드라이버 로드
			Class.forName(jdbc_driver);
			//2.DB연결
			conn = DriverManager.getConnection(jdbc_url, "spring", "spring");

			//커넥션풀에서 커넥션 얻어오기
			/*Context initContext = new InitialContext();
			Context envContext =(Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/orcl"); //datasource 검색
			conn = ds.getConnection();   //conn 을 할당받음
			*/
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) {			
			try {
				if(! rs.isClosed()) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		if(pstmt != null) {
			try {
				if(! pstmt.isClosed()) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				if(! conn.isClosed())  conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}





