package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.Member;

public class MemberController {
	
	public MemberController() {
		// 드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	public void close(PreparedStatement ps, Connection conn, ResultSet result) throws SQLException {
		ps.close();
		conn.close();
		result.close();
	}

	public boolean signUp(Member m) throws SQLException, ClassNotFoundException {
		// member 테이블에 데이터 추가

		if (login(m.getId(), m.getPassword()) == null) {
			Connection conn = getConnect();
			String query = "INSERT INTO member VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, m.getId());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());

			ps.executeUpdate();
			close(ps, conn);
			return true;
		} else {
			return false;
		}

	}
	
	public String login(String id, String password) throws SQLException {
		// 멤버 테이블에서 id와 password로 정보 하나 가져오기 (SELECT)
		// id와 비밀번호가 같으면 이름 출력, 아니면 null.
		Connection conn = getConnect();
		String query = "SELECT * FROM member WHERE id = ? AND password = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		String name = null;
		if (rs.next()) {
			name = rs.getString("name");
		} 
		close(ps, conn, rs);
		return name;
		
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) throws SQLException {
		// login 메서드 활용 후 사용자 이름이 null이 아니면 해당 UPDATE 문 구현
		// member 테이블에서 id로 새로운 패스워드로 변경 (UPDATE) 
		Connection conn = getConnect();
		String query = "UPDATE member set password = ? where password = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		if (login(id, oldPw) == null) {
			return false;
		} else {
			System.out.println("업데이트하쟝");
			ps.setString(1, newPw);
			ps.setString(2, oldPw);
			
			ps.executeUpdate();
			close(ps, conn);
			return true;
		}
	}
	
	public void changeName(String id, String changeName) throws SQLException {
		// member 테이블에서 id로 새로운 이름으로 변경 (UPDATE)
		Connection conn = getConnect();
		String query = "UPDATE member set name = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, changeName);
		ps.setString(2, id);
		
		ps.executeUpdate();
		close(ps, conn);
	}
	
}
