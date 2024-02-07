package E_BookMVC2.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import E_BookMVC2.model.vo.Book;
import E_BookMVC2.model.vo.Rent;


public class RentDAO {
	public RentDAO() {
		try {
			// 한 번만 드라이버 로딩하면 되기 때문에 생성자에 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// DB 연결
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "1234");
	}

	// 자원 반납
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	// 자원 반납
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		close(ps, conn);
	}

	// 1. 책 대여
	public int rentBook(int bkNo, int memberNo) throws SQLException {
		Connection conn = getConnect();
		String query = "INSERT INTO tb_rent(member_no, bk_no) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setInt(1, memberNo);
		ps.setInt(2, bkNo);
		int result = ps.executeUpdate();
		close(ps, conn);
		return result;
	}

	// 2. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook(int no) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT * FROM tb_rent JOIN tb_book USING (bk_no) WHERE member_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();

		ArrayList<Rent> list = new ArrayList<>();
		while (rs.next()) {
			Rent rent = new Rent();
			rent.setRentNo(rs.getInt("rent_no"));
			rent.setRentDate(rs.getDate("rent_date"));
			rent.setBook(new Book(rs.getString("bk_title"), rs.getString("bk_author")));
			list.add(rent);
		}
		return list;
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
	}

	// 3. 대여 취소
	public int deleteRent(int no) throws SQLException {
		Connection conn = getConnect();
		String query = "DELETE FROM tb_rent WHERE rent_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, no);
		int result = ps.executeUpdate();
		close(ps, conn);
		return result;
	}

}
