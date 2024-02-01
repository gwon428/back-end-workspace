package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DBConnectionTest1 {

	public static void main(String[] args) {

		// JDBC (Java Database Connectivity) : Java와 DB 연결

		/*	작업 4단계 [시험]
		 	1. 드라이버 로딩 
		 	2. 데이터베이스와 연결 
		 	3. Statement 객체 생성 - SELECT
		 	4. 쿼리문 실행
		 */
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 로딩");

			// 2. 데이터베이스와 연결 (url(스키마까지), 사용자, 비밀번호)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
			System.out.println("2. 데이터베이스와 연결");

			// 3. Statement 객체 생성	- SELECT
			String query = "SELECT * FROM employee";
			PreparedStatement ps = conn.prepareStatement(query);
			
			// 4. 쿼리문 실행
			// ps.executeQuery()의 반환값이 ResultSet.
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String empId = rs.getString("emp_id");
				String empName = rs.getString("emp_name");
				int salary = rs.getInt("salary");
				float bonus = rs.getFloat("bonus");
				Date hireDate = rs.getDate("hire_Date");
				char entYn = rs.getString("ent_Yn").charAt(0);
				
				System.out.println(empId + " / " + empName + " / " + salary + " / " + bonus + " / " + hireDate + " / " + entYn);
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패!");
		}

	}

}
