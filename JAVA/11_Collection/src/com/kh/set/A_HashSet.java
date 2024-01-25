package com.kh.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.kh.set.model.Person;

// HashSet : Set 인터페이스를 구현한 대표적인 컬렉션 클래스

/*	Set의 특징
  	- 중복 없음
  	- 순서 없음
 
 */

public class A_HashSet {

	public static void main(String[] args) {
		A_HashSet a = new A_HashSet();
//		a.method1();
		a.method2();
	}

	public void method1() {
		Set<String> set = new HashSet<>();
		
		set.add("라미란");
		set.add("공명");
		set.add("염혜란");
		set.add("박병은");
		
		// 중복 추가 X
		set.add("라미란");
		System.out.println(set);
		System.out.println(set.size());
		System.out.println("라미란이 포함되어 있는가? " + set.contains("라미란"));
		
		// 순서가 없어서 인덱스를 쓸 수 없음!
		set.remove("박병은");
		System.out.println(set);
		
		set.clear();
		System.out.println(set);
		System.out.println("비어있는가? " + set.isEmpty());
		
	}
	
	// set으로 객체 다루기
	public void method2() {
		Set<Person> set = new HashSet<>();
		
		set.add(new Person("라미란", 48));
		set.add(new Person("공명", 29));
		set.add(new Person("염혜란", 47));
		set.add(new Person("박병은", 46));
		System.out.println(set);
		
		// 객체의 주소값을 가지고 비교하기 대문에 모두 다른 객체로 인식해서 중복 제거되지 X
			// -> hashCode, equals 메서드 재정의 자동 생성 => 객체 중복 제거됨 (자동 생성)
		set.add(new Person("라미란", 48));
		set.add(new Person("라미란", 48));
		System.out.println(set);
		
		for(Person p : set) {
			System.out.println(p);
		}
		
		/*	Iterator (반복자)
		 	- 컬렉션에 저장된 요소를 접근하는 데 사용하는 인터페이스
		 	- iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용
		 */
		// iterator()를 호출해서 Iterator 구현한 객체 it를 생성
		Iterator<Person> it = set.iterator();
		
		while(it.hasNext()) {	// 이 다음에 읽어올 요소가 있으면 true (없으면 false => 마지막 객체이기 때문)
			System.out.println(it.next());	// 다음 요소를 읽어옴
		}
	}

}
