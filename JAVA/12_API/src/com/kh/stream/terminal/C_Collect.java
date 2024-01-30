package com.kh.stream.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kh.stream.model.Student;

/*	수집(Collect)
 	- 최종 처리 기능으로 필터링 또는 매핑한 요소들을 새로운 컬렉션으로 담아서 리턴하는 collect() 제공
 */
public class C_Collect {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("이상현", 15, "남자", 50, 80),
				new Student("정동준", 18, "남자", 90, 90),
				new Student("이상호", 16, "남자", 80, 70),
				new Student("권예빈", 17, "여자", 75, 80),
				new Student("조세미", 14, "여자", 85, 65)
				);
		
		// 1. List 컬렉션으로 수집 -> 수학 점수가 80점 이상인 사람들만
		List<Student> list = students.stream()
			.filter(stu -> stu.getMath() >= 80)
			.collect(Collectors.toCollection(() -> new ArrayList<>()));			// collect 조건
		
		System.out.println(list);
		
		
		// 2. Set 컬렉션으로 수집 -> 중학생인 사람만 (14~16살), HashSet
		Set<Student> set = students.stream()
				.filter(stu -> stu.getAge() >= 14 && stu.getAge() <= 16)
				.collect(Collectors.toCollection(() -> new HashSet<>()));
		
		System.out.println(set);
		
		
		// 3. Map 컬렉션으로 수집
		Map<String, Integer> map = students.stream()
				.collect(Collectors.toMap(student -> student.getName(), student -> student.getAge()));
		
		System.out.println(map);
	}

}
