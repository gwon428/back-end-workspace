package person;

import java.sql.SQLException;

public class PersonTest_1 {
	
	public static String query = "";
	PersonController_ pc = new PersonController_();
	
	public static void main(String[] args) throws SQLException {

		PersonTest_1 pt = new PersonTest_1();
		
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

	}

	public void addPerson(int i, String name, String addr) throws SQLException {
			if(pc.addPerson(i, name, addr)==1) {
				System.out.println(name + "님, 회원가입 완료!");
			}
	}

	public void updatePerson(int i, String addr) throws SQLException {
		int result = pc.updatePerson(i, addr);
		if (result == 1) {
			System.out.println(result + "명, 수정!");
		}
	}

	private void removePerson(int i) throws SQLException {
		int result = pc.removePerson(i);
		if (result == 1) {
			System.out.println(result + "명, 삭제!");
		}
	}	
	
	// person 테이블에 있는 데이터 전체 보여주기
	private void searchAllPerson() throws SQLException {
		for(Person_ p : pc.searchAllPerson()) {
			System.out.println(p);
		}
	}

	private void searchPerson(int i) throws SQLException {
		System.out.println(pc.searchPerson(i));
		
	}
}
