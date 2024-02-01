package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.Serverinfo;

public class DBConnectionTest3 {
	
	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로딩
			Class.forName(Serverinfo.DRIVER_NAME);
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
			
			// 3. 쿼리 준비 - UPDATE [JAVA에서 값을 받는 부분은 ?로 작성]
			String query = "UPDATE employee_copy SET emp_name = ? WHERE emp_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			// ?로 받은 값 채우는 세팅이 필요
			// 4. 쿼리문 실행
			ps.setString(1, "김웡카");		// setInt(1, ) : 첫 번째 ?를 뜻함
			ps.setInt(2, 700);
			
			System.out.println(ps.executeUpdate() + "명 변경!");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
