package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssamz.biz.common.JDBCUtil;

public class SelectUserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// JDBC 관련 변수
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			// JDBC 3단계 : Statement 생성
			String sql = "select * from users";
			stmt = conn.prepareStatement(sql);
			
			// JDBC 4단계 : SQL 전송
			rs = stmt.executeQuery();
			
			// JDBC 5단계 : 조회 결과 사용
			System.out.println("[ USER 목록 ]");
			
			while (rs.next()) {
				System.out.print(rs.getString("ID") + " : " );
				System.out.print(rs.getString("PASSWORD") + " : " );
				System.out.print(rs.getString("NAME") + " : " );
				System.out.println(rs.getString("ROLE"));
			}
			
			/*
			rs.next();
			System.out.print(rs.getString("ID") + " : " );
			System.out.print(rs.getString("PASSWORD") + " : " );
			System.out.print(rs.getString("NAME") + " : " );
			System.out.println(rs.getString("ROLE"));
			rs.next();
			System.out.print(rs.getString("ID") + " : " );
			System.out.print(rs.getString("PASSWORD") + " : " );
			System.out.print(rs.getString("NAME") + " : " );
			System.out.println(rs.getString("ROLE"));
			rs.next();
			System.out.print(rs.getString("ID") + " : " );
			System.out.print(rs.getString("PASSWORD") + " : " );
			System.out.print(rs.getString("NAME") + " : " );
			System.out.println(rs.getString("ROLE"));
			rs.next();
			System.out.print(rs.getString("ID") + " : " );
			System.out.print(rs.getString("PASSWORD") + " : " );
			System.out.print(rs.getString("NAME") + " : " );
			System.out.println(rs.getString("ROLE"));
			rs.next();
			System.out.print(rs.getString("ID") + " : " );
			System.out.print(rs.getString("PASSWORD") + " : " );
			System.out.print(rs.getString("NAME") + " : " );
			System.out.println(rs.getString("ROLE"));
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCUtil.close(rs, stmt, conn);
			
		}
		

		
		
	}

}
