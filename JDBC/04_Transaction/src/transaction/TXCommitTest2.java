package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TXCommitTest2 {

	public static void main(String[] args) {

		/*	대윤 -> 대규 : 50만원씩 이체
		 	이 관련 모든 쿼리를 하나로 묶는다! (트랜잭션 사용)
		 	대윤님의 잔액이 마이너스가 되면 이체 취소가 되어야 함!
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
			
			conn.setAutoCommit(false);
			
			String query1 = "UPDATE bank SET balance = balance - ? WHERE name = ?";
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setInt(1, 500000);
			ps1.setString(2, "정대윤");
			ps1.executeUpdate();
			
			String query2 = "UPDATE bank SET balance = balance + ? WHERE name = ?";
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setInt(1, 500000);
			ps2.setString(2, "신대규");
			ps2.executeUpdate();
			
			String query3 = "SELECT balance FROM bank WHERE name = ?";
			PreparedStatement ps3 = conn.prepareStatement(query3);
			ps3.setString(1, "정대윤");
			
			ResultSet rs = ps3.executeQuery();
			
			if (rs.next()) {
				if (rs.getInt("balance") < 0){
					conn.rollback();
					System.out.println("이체 가능한 금액이 없어 이체가 취소됩니다.");
				} else {
					conn.commit();
					System.out.println("50만원이 이체되었습니다.");
				}
			}
			conn.setAutoCommit(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
