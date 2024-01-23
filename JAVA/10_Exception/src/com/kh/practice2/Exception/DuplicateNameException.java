package com.kh.practice2.Exception;

public class DuplicateNameException extends Exception {
	
	//Exception도 클래스이기 때문에 직접 만들수도 있음 !
	public DuplicateNameException() {
		this("중복된 사람이 있어서 에러 발생!");
		// this(message)가 super(message)로 감 !
	}

	public DuplicateNameException(String message) {
		// 에러 처리를 메세지로 받겠다 (?)
		super(message);
	}
	
	
}
