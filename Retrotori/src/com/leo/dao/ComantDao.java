package com.leo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ComantDao {
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private ComantDao() {}
	
	public static ComantDao instance = new ComantDao();
	
	public static ComantDao getInstance() {
		return instance;
	}
	
	private Connection getConnetion () throws SQLException {
		Connection conn = null;
		
		try {
			Context ctx = new  InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();					
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public int insertComant(String gId, String mId, String comant) { //코멘트 입력
		int result = FAIL;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO COMANT (CNUM, GID, MID, COMANT) " + 
					 "VALUES (COMANT_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gId);
			pstmt.setString(2, mId);
			pstmt.setString(3, comant);
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("코멘트 입력 성공");
				result = SUCCESS;
			} else {
				System.out.println("코멘트 입력 실패");
				result = FAIL;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		
		
		return result; 
	}
	
	public int deleteComant(String gId, String mId) { //코멘트 삭제
		int result = FAIL;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM COMANT WHERE GID = ? AND MID = ?";
		
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gId);
			pstmt.setString(2, mId);
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("코멘트 삭제 성공");
				result = SUCCESS;
			} else {
				System.out.println("코멘트삭제 실패");
				result = FAIL;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		
		return result; 
	}

}
