package com.kh.practice2.controller;

import com.kh.practice2.Exception.DuplicateNameException;
import com.kh.practice2.Exception.RecordNotFoundException;
import com.kh.practice2.model.Member;

public class MemberController {
	
	private Member[] memArr = new Member[3];
	public int count = 0;
	
	
	// 멤버 추가
	public void insertMember(Member m) throws DuplicateNameException, RecordNotFoundException {
		
		int index = checkId(m.getId());
		if(index == -1) {
			memArr[count++] = new Member(m.getId(), m.getName(), m.getPassword(), m.getEmail(), m.getGender(), m.getAge());
		} else {
			// 회원이 기존에 있는 경우
			throw new DuplicateNameException();
		}
		

//		System.out.println(Arrays.toString(memArr));	// 임시 확인
	}

	// 멤버 인덱스를 아이디로 조회 --> 에러 발생 시키는 부분이 추가/수정 !
	public int checkId(String id) throws DuplicateNameException, RecordNotFoundException {
		for (int i = 0; i < memArr.length; i++) {
			if (memArr[i] != null && memArr[i].getId().equals(id)) {
				throw new DuplicateNameException();
			} else {
//				throw new RecordNotFoundException();
			}
		}
		return -1;		// 100%의 확률로 인덱스가 아닌 수
	}
	
	// 멤버 수정
	public int checkUpdateId(String id) throws DuplicateNameException, RecordNotFoundException {
		for (int i = 0; i < memArr.length; i++) {
			if (memArr[i] != null && memArr[i].getId().equals(id)) {
//				throw new DuplicateNameException();
			} else {
				throw new RecordNotFoundException();
			}
		}
		return -1;		// 100%의 확률로 인덱스가 아닌 수
	}
		
	// 멤버 수정
	public void update(String id, String name, String email, String password) throws DuplicateNameException, RecordNotFoundException {
		int index = checkUpdateId(id);
		memArr[index].setName(name);
		memArr[index].setEmail(email);
		memArr[index].setPassword(password);
	}
	
	// 멤버 조회
	public Member[] info() {
		return memArr;
	}
	
}


