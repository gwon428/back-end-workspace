package person;

import java.sql.SQLException;

public class PersonTest {

	public static String query = "";
	PersonController pc = new PersonController();

	public static void main(String[] args) throws SQLException {

		PersonTest pt = new PersonTest();
		try {
			// person 테이블에 추가
			pt.addPerson(111, "김강우", "서울");
			pt.addPerson(222, "고아라", "제주도");
			pt.addPerson(333, "강태주", "경기도");

			// person 테이블에서 데이터 수정
			pt.updatePerson(111, "제주도");

			// person 테이블에서 데이터 삭제
			pt.removePerson(333);

			// person 테이블에 있는 데이터 전체 보여주기
			pt.searchAllPerson();

			// person 테이블에서 데이터 한 개만 가져오기
			pt.searchPerson(111);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// person 테이블에 추가 - INSERT
	public void addPerson(int id, String name, String addr) throws SQLException {
		int result = pc.addPerson(id, name, addr);
		if (result == 1) {
			System.out.println(name + "님, 회원가입 완료!");
		}

	}

	// person 테이블에서 데이터 수정 - UPDATE
	public void updatePerson(int id, String addr) throws SQLException {
		int result = pc.updatePerson(id, addr);
		if (result == 1) {
			System.out.println(result + "명 수정!");
		}
		
	}

	// person 테이블에서 데이터 삭제 - DELETE
	private void removePerson(int id) throws SQLException {
		int result = pc.removePerson(id);
		if (result == 1) {
			System.out.println(result + "명 삭제!");
		}
	}

	// person 테이블에 있는 데이터 전체 보여주기
	private void searchAllPerson() throws SQLException {
		for(Person p : pc.searchAllPerson()) {
			System.out.println(p);
		}
	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	private void searchPerson(int id) throws SQLException {
		System.out.println(pc.searchPerson(id));
	}
}
