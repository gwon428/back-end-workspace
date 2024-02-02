package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// 기능 하나에 쿼리문 하나
public class PersonController {

	public PersonController() {
		// 드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 고정적인 반복 --> DB 연결, 자원 반납 -> 공통적인 메서드 정의 -> 메서드마다 호출해서 사용할 수 있게끔
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

	// 변동적인 반복 --> 비즈니스 로직. DAO (Database Access Object)
	// Person__VO(ValueObject), Person_DAO(DatabaseAccessObject) 클래스가 두 개.
	public int addPerson(int id, String name, String addr) throws SQLException {
		// 2. DB 연결
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "INSERT INTO person VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 실행
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, addr);

		int result = ps.executeUpdate();

		// 5. 자원 반납
		close(ps, conn);
		return result;
	}

	public int updatePerson(int id, String addr) throws SQLException {
		// 2. DB 연결
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "UPDATE person SET address = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, addr);
		ps.setInt(2, id);

		int result = ps.executeUpdate();

		close(ps, conn);
		return result;
	}

	public int removePerson(int id) throws SQLException {
		Connection conn = getConnect();

		String query = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setInt(1, id);

		int result = ps.executeUpdate();

		close(ps, conn);
		return result;
	}

	public ArrayList<Person> searchAllPerson() throws SQLException {
		// 2. DB 연결
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "SELECT * FROM person";
		PreparedStatement ps = conn.prepareStatement(query);

		ResultSet rs = ps.executeQuery();
		ArrayList<Person> list = new ArrayList<>();

		while (rs.next()) {
			// 생성자 방식
			list.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
			
			// setter 방식
//			Person person = new Person();
//			person.setId(rs.getInt("id"));
//			person.setName(rs.getString("name"));
//			person.setAddress(rs.getString("address"));
//			list.add(person);
		}

		close(ps, conn, rs);
		return list;
	}

	public Person searchPerson(int id) throws SQLException {
		// 2. DB 연결
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "SELECT * FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		Person p = new Person();

		if (rs.next()) {
			p.setId(id);
			p.setName(rs.getString("name"));
			p.setAddress(rs.getString("address"));
		}

		close(ps, conn, rs);
		return p;
	}
}
