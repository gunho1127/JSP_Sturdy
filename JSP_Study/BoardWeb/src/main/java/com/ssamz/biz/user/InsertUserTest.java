package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ssamz.biz.common.JDBCUtil;

public class InsertUserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. UserDAO 객체를 생성합니다.
		UserDAO dao = new UserDAO();
		
		// 2. 회원 정보를 등록합니다.
		UserVO vo = new UserVO();
		vo.setName("쌤즈");
		vo.setRole("USER");
		vo.setId("ssamz4");
		vo.setPassword("ssamz123");
		dao.insertUser(vo);
		
		//dao.insertUser("ADMIN", "쌤즈", "ssamz123", "ssamz3");
		//dao.insertUser("ssamz3", "ssamz123", "쌤즈", "ADMIN");
		
		
		// 3. 목록을 조회합니다.
		dao.getUserList();
		
		/*
		// JDBC 관련 변수
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			// JDBC 3단계 : Statement 생성
			String sql = "insert into users values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			
			// JDBC 4단계 : SQL전송
			// ? 값 설정
			stmt.setString(1, "ssamz3");
			stmt.setString(2, "ssamz123");
			stmt.setString(3, "쌤즈");
			stmt.setString(4, "ADMIN");
			
			// SQL 전송
			int count = stmt.executeUpdate();
			System.out.println(count + "건 데이터 처리 성공!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCUtil.close(stmt, conn);
			
		}
		*/
		
	}

}
