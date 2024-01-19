package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.model.Member;

public class MemberController {
	
	private Member[] memArr = new Member[3];
	public int count = 0;
	
	
	
	// 멤버 추가
	public void insertMember(Member m) {
		memArr[count++] = new Member(m.getId(), m.getName(), m.getPassword(), m.getEmail(), m.getGender(), m.getAge());

//		System.out.println(Arrays.toString(memArr));	// 임시 확인
	}

	// 멤버 인덱스를 아이디로 조회
	public int checkId(String id) {
		for (int i = 0; i < memArr.length; i++) {
			if (memArr[i] != null && memArr[i].getId().equals(id)) {
				return i;
			}
		}
		return -1;		// 100%의 확률로 인덱스가 아닌 수
	}
		
	// 멤버 수정
	public void update(String id, String name, String email, String password) {
		int index = checkId(id);
		memArr[index].setName(name);
		memArr[index].setEmail(email);
		memArr[index].setPassword(password);
	}
	
	// 멤버 조회
	public Member[] info() {
		return memArr;
	}
	
}


