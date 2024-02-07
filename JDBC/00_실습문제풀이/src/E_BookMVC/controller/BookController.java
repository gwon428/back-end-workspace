package E_BookMVC.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import E_BookMVC.model.vo.Book;
import E_BookMVC.model.vo.Publisher;

public class BookController {

	public BookController() {
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

	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		Connection conn = getConnect();
		// left join : null이 있어도 일단 join으로 연결
		String query = "SELECT * FROM tb_book LEFT JOIN tb_publisher USING (pub_no)";
		PreparedStatement ps = conn.prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		ArrayList<Book> list = new ArrayList<>();
		while (rs.next()) {
			Book book = new Book();
			book.setBkNo(rs.getInt("bk_no"));
			book.setBkTitle(rs.getString("bk_title"));
			book.setBkAuthor(rs.getString("bk_author"));
			book.setBkPrice(rs.getInt("bk_price"));
			book.setPublisher(new Publisher(rs.getInt("pub_no"), rs.getString("pub_name"), rs.getString("phone")));
			list.add(book);
		}
		close(rs, ps, conn);
		return list;
	}

	// 2. 책 등록
	public void registerBook(String title, String author) throws SQLException {
		Connection conn = getConnect();
		String query = "INSERT INTO tb_book (bk_title, bk_author) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, title);
		ps.setString(2, author);

		ps.executeUpdate();
		close(ps, conn);
	}

	// 3. 책 삭제
	public void sellBook(int no) throws SQLException {
		Connection conn = getConnect();
		String query = "DELETE FROM tb_book WHERE bk_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setInt(1, no);
		if (ps.executeUpdate() == 0)
			throw new SQLException(); // 일부러 예외 발생

		close(ps, conn);
	}

}
