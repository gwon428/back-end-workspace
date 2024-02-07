package E_BookMVC2.controller;

import java.sql.SQLException;

import E_BookMVC2.model.dao.MemberDAO;
import E_BookMVC2.model.vo.Member;

public class MemberController {

	private MemberDAO dao = new MemberDAO();

	// 4. 회원가입
	public boolean registerMember(String id, String password, String name) {
		try {
			if(dao.registerMember(id, password, name)==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 5. 로그인
	public Member login(String id, String pwd) {
		Member member;
		try {
			member = dao.login(id, pwd);
			if (member.getStatus().equals("Y")) return member;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 4. 회원탈퇴
	public boolean deleteMember(int no) {
		try {
			if(dao.deleteMember(no)==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
