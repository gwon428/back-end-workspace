package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.Serverinfo;

public class DBConnectionTest2 implements Serverinfo {

	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비 - INSERT [JAVA에서 값을 받는 부분은 ?로 작성]
			String query = "INSERT INTO employee_copy(emp_id, emp_name, emp_no) VALUES (?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(query);
			
			// ?로 받은 값 채우는 세팅이 필요
			// 4. 쿼리문 실행
			ps.setInt(1, 700);		// setInt(1, ) : 첫 번째 ?를 뜻함
			ps.setString(2, "권예빈");
			ps.setString(3, "111111-2222222");
			
			System.out.println(ps.executeUpdate() + "명 추가!");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
