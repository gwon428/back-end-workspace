package com.kh.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.kh.set.model.Person;

/*	TreeSet 
 	- 저장과 동시에 자동 오름차순 정렬 (HashSet + 정렬)	[[들어가는 순간마다 정렬]]
 	- HashSet보다 데이터 추가, 삭제에 시간이 더 걸림
 */
public class B_TreeSet {

	public static void main(String[] args) {
		B_TreeSet b = new B_TreeSet();
//		b.method1();		// String에는 자바에서 제공하는 Comparable가 자동으로 적용되어 있기 때문에 정렬이 자동 적용
		b.method2();		// 우리가 만든 객체 Person은 Comparable가 없기 때문에 정렬이 안 됨 => 재정의
	}

	public void method1() {
		Set<String> set = new TreeSet<>();
		
		set.add("라미란");
		set.add("공명");
		set.add("염혜란");
		set.add("박병은");
		
		// 중복 추가 X
		set.add("라미란");
		System.out.println(set);			// [공명, 라미란, 박병은, 염혜란]	<== 자동으로 오름차순 정렬됨!
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
		TreeSet<Person> set = new TreeSet<>();
		
		
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
