package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import config.Serverinfo;

public class DBConnectionTest4 {
	
	public static void main(String[] args) {
		
		try {
			
			// properties 파일 불러오기
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			// 1. 드라이버 로딩
			Class.forName(Serverinfo.DRIVER_NAME);
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
			
			// 3. 쿼리 준비 - DELETE [JAVA에서 값을 받는 부분은 ?로 작성]
			String query = p.getProperty("delete");
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			// ?로 받은 값 채우는 세팅이 필요
			// 4. 쿼리문 실행
			ps.setInt(1, 900);		// setInt(1, ) : 첫 번째 ?를 뜻함
			
			System.out.println(ps.executeUpdate() + "명 삭제!");

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
