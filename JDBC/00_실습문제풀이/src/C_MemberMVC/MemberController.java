package C_MemberMVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberController {
	
	public MemberController() {
		// 생성자나 메인 메서드의 예외 처리는 try-catch로
		// 1. 드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 2. DB 연결
	public Connection getConnect() throws SQLException {	// URL		// 사용자	// 비밀번호
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null) ps.close();
		if (conn != null) conn.close();
	}
	
	public void close(PreparedStatement ps, Connection conn, ResultSet rs) throws SQLException {
		close(ps, conn);
		if (rs!= null) rs.close();
	}
	
	
	// member 테이블에 데이터 추가
	public boolean signUp(Member m) throws SQLException, ClassNotFoundException {
		// --> 로그인 기능 구현이 먼저 되어야 함!
		// --> login 결과값이 null이 아닌 경우만 구현! 그게 아닐 때는 false만 리턴
			Connection conn = getConnect();
			// 회원가입 기능 구현!
			// -> 아이디가 기존에 있는지 체크 여부! > 원래 로그인이 아닌 다른 메서드를 만들어서 체크
			// -> member 테이블에 데이터 추가! (INSERT)
			
			if(!idCheck(m.getId())) {
				String query = "INSERT INTO member VALUES(?, ?, ?)";
				PreparedStatement ps = conn.prepareStatement(query);

				ps.setString(1, m.getId());
				ps.setString(2, m.getPassword());
				ps.setString(3, m.getName());
				
				ps.executeUpdate();
				close(ps, conn);
				return true;
			} 			
			return false;
	}
	
	public boolean idCheck(String id) throws SQLException {
		// 존재할 때 true 아니면 false
		Connection conn = getConnect();
		String query = "SELECT id FROM member WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		String checkId = null;
		if(rs.next()) {
			checkId = rs.getString("id");
		}
		close(ps, conn, rs);
		if(checkId != null) return true;
		return false;
	}
	
	
	
	// 로그인 기능 구현!
	// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기! (SELECT)
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
	
	// 비밀번호 바꾸기 기능 구현!
	// -> login 메서드 활용 후 사용자 이름이 null이 아니면 해당 UPDATE 문 구현!
	// -> member 테이블에서 id로 새로운 패스워드로 변경 (UPDATE)
	public boolean changePassword(String id, String oldPw, String newPw) throws SQLException {
		// login 메서드 활용 후 사용자 이름이 null이 아니면 해당 UPDATE 문 구현
		// member 테이블에서 id로 새로운 패스워드로 변경 (UPDATE) 
		Connection conn = getConnect();
		PreparedStatement ps = null;
		boolean result = false;
		if (login(id, oldPw) != null) {
			String query = "UPDATE member SET password = ? WHERE id = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, newPw);
			ps.setString(2, id);
			ps.executeUpdate();
			result = true;
		} 
		close(ps, conn);
		return result;
	}
	
	// 이름 바꾸기 기능 구현!
	// -> member 테이블에서 id로 새로운 이름으로 변경 (UPDATE)
	public void changeName(String id, String changeName) throws SQLException {
		// member 테이블에서 id로 새로운 이름으로 변경 (UPDATE)
		Connection conn = getConnect();
		String query = "UPDATE member SET name = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, changeName);
		ps.setString(2, id);
		
		ps.executeUpdate();
		close(ps, conn);
	}
	
}
