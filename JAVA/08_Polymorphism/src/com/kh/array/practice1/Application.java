package com.kh.array.practice1;

import java.util.Arrays;

import com.kh.array.practice1.model.Student;

public class Application {

	/*	배열
	 	자료형[] 배열명 = new 자료형[배열크기];
	 	
	 	객체 생성
	 	
	 */
	
	public static void main(String[] args) {
		
		Student[] stuArr = new Student[5];
		stuArr[0] = new Student("김길동", "자바", 100);
		stuArr[1] = new Student("박길동", "디비", 50);
		stuArr[2] = new Student("이길동", "화면", 85);
		stuArr[3] = new Student("정길동", "서버", 60);
		stuArr[4] = new Student("홍길동", "자바", 20);
		
		System.out.println(stuArr);		// 주소값 출력
		System.out.println(Arrays.toString(stuArr));		// Student에서 재정의하지 않으면 이것도 주소값으로 출력됨
		
		System.out.println("\n반복문을 통한 출력");
		
		for (int i=0; i<stuArr.length; i++) {
			System.out.println(stuArr[i]);
		}
		
		System.out.println("\n향상된 for문");
		for (Student student : stuArr) {
			System.out.println(student);
		}
		
	}

}
