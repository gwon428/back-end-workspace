package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.List;

import com.kh.stream.model.Student;

/*	매칭 (boolean 타입으로 return)
 	- 최종 처리 단계에서 요소들이 특정 조건에 만족하는지 조사하는 역할
 	- allMatch	: 모든 요소들이 매개 값으로 주어진 조건을 만족하는지 조사
 	- anyMatch	: 최소한 한 개의 요소가 매개 값으로 주어진 조건을 만족하는지 조사
 	- noneMatch	: 모든 요소들이 매개 값으로 주어진 조건을 만족하지 않는지 조사
 */
public class A_Match {

	public static void main(String[] args) {
		A_Match a = new A_Match();
		
//		a.method1();	// allMaych, anyMaych, noneMatch
		a.method2();	// 연습문제
	}

	// 
	public void method1() {
		int[] values = {2, 4, 6};
		System.out.println("주어진 배열 : " + Arrays.toString(values));
		
		// allMatch : '모든' 요소들이 조건을 만족하는지
		boolean result = Arrays.stream(values)
			.allMatch(value -> value % 2 == 0);
		System.out.println("[allMatch] 위 배열이 짝수만 가지고 있는가? " + result);
		
		// anyMatch : '최소한 한 개'의 요소가 조건을 만족하는지
		result = Arrays.stream(values)
			.anyMatch(value -> value % 3 == 0);
		System.out.println("[anyMatch] 위 배열이 3의 배수 값이 하나라도 있는가? " + result);
		
		// noneMatch : '모든' 요소들이 조건을 만족하지 '않는지'
		result = Arrays.stream(values)
				.noneMatch(value -> value % 5 == 0);
		System.out.println("[noneMatch] 위 배열이 5의 배수 값이 포함하고 있지 않는가? " + result);
	}
	
	public void method2() {
		List<Student> students = Arrays.asList(
				new Student("이상현", 25, "남자", 50, 80),
				new Student("정동준", 28, "남자", 90, 90),
				new Student("이상호", 26, "남자", 80, 70),
				new Student("권예빈", 27, "여자", 75, 80),
				new Student("조세미", 24, "여자", 85, 65)
				);
		
		// 1. 나이가 25살 이상인 학생들이 모두 남자인지 확인
		boolean result = students.stream()
				.filter(stu -> stu.getAge() >= 25)
				.allMatch(stu -> stu.getGender().equals("남자"));
		
		System.out.println("나이가 25살 이상인 학생들이 모두 남자인가? : " + result);
		
		
		// 2. 남학생들 중에 평균이 70점 이상인 학생이 한 명이라도 존재하는지 확인
		result = students.stream()
				.filter(stu -> stu.getGender().equals("남자"))
				.anyMatch(stu -> ((stu.getEnglish() + stu.getMath()) / 2 >= 70));
		
		System.out.println("남학생들 중 평균이 70점 이상인 학생이 한 명이라도 존재하는가? : " + result);
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
