package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.kh.model.Book;
import com.kh.model.Member;
import com.kh.model.RentBook;

public class BookController {
	
	Member member = new Member();
	Calendar cal = Calendar.getInstance();
	public BookController() {
		// 드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "1234");
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
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
//		Connection conn = getConnect();
//		String query = "SELECT * FROM tb_book";
//		PreparedStatement ps = conn.prepareStatement(query);
//		
//		ResultSet rs = ps.executeQuery();
//		while(rs.next()) {
//			System.out.println(rs.getInt("bk_no") + "번 책 : " + rs.getString("bk_title") + " (" + rs.getString("bk_author") + ")");
//		}
//		
		Connection conn = getConnect();
		String query = "SELECT * FROM tb_book";
		PreparedStatement ps = conn.prepareStatement(query);

		ResultSet rs = ps.executeQuery();
		
		ArrayList<Book> list = new ArrayList<>();
		
		while(rs.next()) {
			list.add(new Book(rs.getInt("bk_no"), rs.getString("bk_title"), rs.getString("bk_author")));
		}
		close(ps, conn, rs);
		return list;
	}

	// 2. 책 등록
	public boolean registerBook(String title, String author) throws SQLException {
		Connection conn = getConnect();
		String query = "INSERT INTO tb_book (bk_title, bk_author) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, title);
		ps.setString(2, author);

		int result = ps.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	// 3. 책 삭제
	public boolean sellBook(int num) throws SQLException {
		Connection conn = getConnect();
		String query = "DELETE FROM tb_book WHERE bk_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, num);
		
		int result = ps.executeUpdate();
		if(result == 1) {
			return true;
		} else {
			return false;
		}
	}

	// 4. 회원가입
	public boolean registerMember(Member m) throws SQLException {
		if(login(m.getId(), m.getPassword()) == null) {
			Connection conn = getConnect();
			String query = "INSERT INTO tb_member(member_id, member_pwd, member_name) VALUES (?, ?, ?)";
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

	// 5. 로그인
	public String login(String id, String pwd) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT * FROM tb_member WHERE member_id = ? AND member_pwd = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, pwd);
		
		ResultSet rs = ps.executeQuery();
		String name = null;
		if(rs.next()) {
			name = rs.getString("member_name");
		}
		
		member.setId(id);
		member.setPassword(pwd);
		
		close(ps, conn, rs);
		return name;
	}

	
	
	// 1. 책 대여
	public boolean rentBook(int num) throws SQLException {
		boolean check = checkBook(num);
		int num2 = -1;
		if (check) {
			// 본인의 대여 목록에 없으므로 대여 가능
			Connection conn = getConnect();
			String query1 = "SELECT member_no FROM tb_member WHERE member_id = ?";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setString(1, member.getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				num2 = rs.getInt("member_no");
			}

			String query2 = "INSERT INTO tb_rent(rent_mem_no, rent_book_no) VALUES(?, ?)";
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setInt(1, num2);
			ps2.setInt(2, num);
			ps2.executeUpdate();

			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkBook(int num) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT * FROM tb_book JOIN tb_rent ON (bk_no = rent_book_no) WHERE rent_book_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, num);
		
		ResultSet rs = ps.executeQuery();
		if(!rs.next()) {
			return true;
		} else {
		return false;
		}
	}

	// 2. 내가 대여한 책 조회
	public ArrayList<RentBook> printRentBook() throws SQLException {
		ArrayList<RentBook> list = new ArrayList<>();
		
		Connection conn = getConnect();
		String query = "SELECT * FROM tb_rent JOIN tb_book ON (bk_no = rent_book_no) JOIN tb_member ON (member_no = rent_mem_no) WHERE member_id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, member.getId());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			list.add(new RentBook(rs.getInt("rent_no"), rs.getInt("bk_no"), rs.getString("bk_title"), rs.getString("bk_author"), rs.getDate("rent_date")));
		}
		close(ps, conn, rs);
		return list;
	}

	// 3. 대여 취소
	public boolean deleteRent(int num) throws SQLException {
		Connection conn = getConnect();
		String query = "DELETE FROM tb_rent WHERE rent_book_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, num);
		int result = ps.executeUpdate();
		
		if(result == 1) {
			return true;
		} else {
			return false;
		}
	}

	// 5. 회원 탈퇴
	public boolean deleteMember() throws SQLException {
		Connection conn = getConnect();
		String query = "DELETE FROM tb_member WHERE member_id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, member.getId());
		int result = ps.executeUpdate();
		
		close(ps, conn);
		if(result == 1) {
			return true;
		} else {
			return false;
		}
	}
}
