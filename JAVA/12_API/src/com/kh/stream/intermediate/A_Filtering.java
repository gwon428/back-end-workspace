package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.kh.stream.model.Student;

public class A_Filtering {
	/*	필터링
	 	- 중간 처리 기능으로 요소를 걸러내는 역할
	 */
	public static void main(String[] args) {
		A_Filtering a = new A_Filtering();
//		a.method1();		// distinct
		a.method2();		// filter
	}
	
	// distinct : 중복 제거
	public void method1() {
		
		List<String> names = Arrays.asList("이상현", "정대윤", "이상호", "권예빈", "손민정", "정세영", "조세미", "정대윤", "이상호", "권예빈");
		Stream<String> stream = names.stream();
		stream.forEach(name -> System.out.print(name + " "));
		
		System.out.println();
		
		// stream을 다시 생성
		stream = names.stream();
		stream.distinct().forEach(name -> System.out.print(name + " "));
		
		System.out.println();
		
		// 배열로도 중복 제거
		List<Student> students = Arrays.asList(
					new Student("이상현", 20, "남자", 80, 50),
					new Student("정대윤", 19, "남자", 75, 60),
					new Student("이상호", 21, "남자", 50, 100),
					new Student("권예빈", 18, "여자", 60, 45),
					new Student("손민정", 22, "여자", 70, 90),
					new Student("이상현", 20, "남자", 80, 50),
					new Student("정대윤", 19, "남자", 75, 60)
				);
		// 스트림을 다시 생성
		students.stream().distinct().forEach(student -> System.out.println(student));
		
	}
	
	// filter
	public void method2() {
	
		//
		List<String> names = Arrays.asList("이상현", "정대윤", "이상호", "권예빈", "손민정", "정세영", "조세미");
		
		names.stream()
			.filter(name -> name.startsWith("이"))					// 중간 처리 (중간에 여러 개 올 수 있음. => distinct는 filter의 앞에 오거나 뒤에 올 수 있음.)
			.forEach(name -> System.out.print(name + " "));			// 최종 처리 (하나만 올 수 있음)
		
		//
		List<Student> students = Arrays.asList(
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 60),
				new Student("이상호", 21, "남자", 50, 100),
				new Student("권예빈", 18, "여자", 60, 45),
				new Student("손민정", 22, "여자", 70, 90),
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 60)
			);
		
		System.out.println("\n\n연습 문제");
		
		// 성별이 여자인 요소만 출력
		System.out.println("===성별이 여자인 요소만 출력===");
		students.stream()
			.distinct()
			.filter(student -> student.getGender().equals("여자"))
			.forEach(student -> System.out.println(student));
		
		System.out.println();
		// 수학 점수, 영어 점수 둘다 60점 이상인 요소만 출력
		System.out.println("=== 수학 점수, 영어 점수 둘다 60점 이상인 요소만 출력===");
		students.stream()
			.distinct()
			// (접근할 변수명을 지정 (a도 올 수 있음!) -> 변수명.	~~~
			.filter((Student student) -> {
				return student.getMath() >= 60 && student.getEnglish() >= 60;
			})
//			.filter(student -> student.getMath() >= 60 && student.getEnglish() >= 60)
			.forEach(student -> System.out.println(student));
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
