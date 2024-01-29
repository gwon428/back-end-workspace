package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kh.stream.model.Student;

/*	매핑
 	- 중간 처리 기능으로 스트림의 요소를 다른 요소로 대체하는 역할
 */
public class C_Mapping {

	public static void main(String[] args) {
		C_Mapping c = new C_Mapping();
//		c.method1();		// map
//		c.method2();		// flatMap
		c.method3();		// asDoubleSteram(), asLongStream(), boxed()
	}

	// mapXXX : 요소를 대체하는 요소로 구성된 새로운 스트림 생성
	public void method1() {
		List<Student> students = Arrays.asList(
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 60),
				new Student("이상호", 21, "남자", 50, 100),
				new Student("권예빈", 18, "여자", 60, 45),
				new Student("손민정", 22, "여자", 70, 90)
			);
		
		students.stream()
			.map(student -> student.getName())
			.forEach(name -> System.out.println(name));
		
		// 수학 점수의 평균
		double avg = students.stream()
			.mapToInt(student -> student.getMath())
			.average()
			.getAsDouble(); 		// optional Double -> double (기본 자료형 double로 만들기 위해서)
		
		System.out.println("수학 점수의 평균 : " + avg);
	}
	
	// flatMapXXX : 하나의 요소를 복수의 요소들로 구성된 새로운 스트림을 생성
	public void method2() {
		List<String> list = Arrays.asList("Java11 Lambda", "StreamAPI Filtering Sorted Mapping");
		list.stream()
//			.forEach(str -> System.out.println(str));
			.forEach(System.out::println);
		
		list.stream()
			.flatMap(str -> Arrays.stream(str.split(" ")))
			.forEach(System.out::println);
		
		System.out.println();
		
		list.stream()
			.flatMap((String str) -> {
				String[] array = str.split(" ");		// str를 " "로 쪼개서 stream 배열에 담음
				return Arrays.stream(array);
			})
			.forEach(System.out::println);
	}
	
	/*	asDoubleStream(), asLongStream(), boxed()
	 	1. asDoubleStream : IntStream, LongStream을 DoubleStream으로 변환
	 	2. asLongStream : IntStream을 LongStream으로 변환
	 	3. boxed : int, long, double 요소를 Integer, Long, Double 요소로 박싱
	 */
	public void method3() {
		int[] array1 = {1, 2, 3, 4, 5};
		double[] array2 = {1.1, 2.2, 3.3, 4.4, 5.5};

		// 
		Arrays.stream(array1)
			.asDoubleStream()						// 모든 정수를 실수로 바꿈
			.forEach(System.out::println);
		
		System.out.println();
		
		Arrays.stream(array2)
			.boxed()								// boxed하면 클래스 요소로 바뀌기 때문에 Comparator를 쓸 수 있음
			.sorted(Comparator.reverseOrder())		// Comparator는 객체만
			.forEach(System.out::println);
				
	}
}
