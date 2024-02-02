package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonController_ {

	String query = "";

	public Connection ready() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
	}

	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	public void close(PreparedStatement ps, Connection conn, ResultSet rs) throws SQLException{
		ps.close();
		conn.close();
		rs.close();
	}

	public int addPerson(int i, String name, String addr) throws SQLException {
		ready();
		query = "INSERT INTO person VALUES(?, ?, ?)";
		PreparedStatement ps = ready().prepareStatement(query);

		ps.setInt(1, i);
		ps.setString(2, name);
		ps.setString(3, addr);

		int result = ps.executeUpdate();
		close(ps, ready());
		return result;
	}

	public int updatePerson(int i, String addr) throws SQLException {
		ready();
		query = "UPDATE person SET address = ? WHERE id = ?";
		PreparedStatement ps = ready().prepareStatement(query);

		ps.setString(1, addr);
		ps.setInt(2, i);

		int result = ps.executeUpdate();
		close(ps, ready());
		return result;
	}

	public int removePerson(int i) throws SQLException {
		ready();
		query = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = ready().prepareStatement(query);

		ps.setInt(1, i);

		int result = ps.executeUpdate();
		close(ps, ready());
		return result;
	}

	public ArrayList<Person_> searchAllPerson() throws SQLException {
		ready();
		query = "SELECT * FROM person";
		PreparedStatement ps = ready().prepareStatement(query);
		ResultSet result = ps.executeQuery();
		
		ArrayList<Person_> list = new ArrayList<>();
		
		while(result.next()) {
			list.add(new Person_(result.getInt("id"), result.getString("name"), result.getString("address")));
		}
		
		close(ps, ready(), result);
		return list;
	}

	public Person_ searchPerson(int i) throws SQLException {
		ready();
		query = "SELECT * FROM person WHERE id = ?";
		PreparedStatement ps = ready().prepareStatement(query);
		ps.setInt(1, i);

		ResultSet result = ps.executeQuery();

		Person_ p = null;

		if (result.next()) {
			p.setId(i);
			p.setName(result.getString("name"));
			p.setAddress(result.getString("address"));
		}
		
		close(ps, ready(), result);
		return p;
	}

}
