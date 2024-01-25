package com.kh.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.list.model.Person;

/*	컬렉션
 	- 자바에서 제공하는 자료구조를 담당하는 프레임워크
 	- 자료구조 : 데이터를 효율적으로 이용하는 방법으로 데이터에 편리하게 접근하고, 효율적으로 사용하기 위해서 데이터를 저장하거나 조직하는 방법
 	- java.util 패키지에 컬렉션과 관련된 인터페이스와 클래스들이 포함되어 있음
 	- 컬렉션을 사용하면 데이터의 추가, 삭제, 정렬 등의 처리가 간단하게 해결되어 자료구조적 알고리즘을 구현할 필요가 없음
 	
 *	컬렉션의 장점
 	- 저장하는 크기의 제약이 없다.
 	- 데이터의 추가, 삭제, 정렬 등의 기능 처리가 간단하게 해결
 	- 여러 타입의 데이터가 저장 가능 (가급적으로 같은 데이터 타입<>(제네릭)을 쓰는 것이 좋음)
 	
 *	컬렉션의 종류
 	1. list
 	2. set
 	3. map
 	
 *	List
 	- 자료들을 순차적으로 늘어놓은 구조
 	- 저장되는 객체를 인덱스로 관리하기 때문에 인덱스로 객체를 검색, 삭제할 수 있는 기능
 	- 중복되는 객체 저장이 가능하고, null값도 저장 가능 
 	
 *	List의 특징
 	- 중복 서용
 	- 순서 있음
 	
 *	ArrayList
 	- 저장 용량(capacity)을 초과한 객체들이 들어오면 자동적으로 저장 용량이 늘어난다. [용량 세팅을 할 수는 있는데, 자동적으로 용량이 늘어나기 때문에 의미가 거의 없다고 봐도 됨]
 	- 동기화(Synchronized)를 제공하지 않는다.		[[=> 컬렉션 이후 (스레드, 스트림)]]
 			(제공하고 있는 애도 있긴 함!)
 	- 동기화 : 하나의 자원(데이터)에 대해 여러 개의 스레드가 접근하려 할 때 한 시점에서 하나의 스레드만 사용할 수 있도록 하는 것을 말한다.
 	
 */
public class A_ArrayList {

	public static void main(String[] args) {

		A_ArrayList a = new A_ArrayList();
//		a.method1();
//		a.method2();
		a.method3();
	}

	public void method1() {
//다형성:	List list = new ArrayList();
		List<String> list = new ArrayList<String>();
		
		list.add("신대규");
		list.add("정대윤");
		list.add("조세미");
		list.add("정세영");
		list.add("권예빈");
		
		System.out.println(list);
	}
	
	public void method2() {
		
		/*	제네릭스<> (Generics)
		 	- 컴파일 시 타입을 체크해주는 기능
		 	- <> 다이아몬드 연산자 사용
		 	
		 *	컬렉션에서 사용하는 이유
		 	- 명시된 타입의 객체만 저장하도록 제한을 두기 위해 사용
		 	
		 
		 */
		
		ArrayList<Person> list = new ArrayList<Person>();
		// 이 ArrayList는 데이터타입이 Person인 객체들을 넣는 객체다. 라고 선언하는 것과 같다.
		
		// 1. add : 리스트 끝에 추가
		list.add(new Person("전현무", "삼성동", 46)); //0
		list.add(new Person("남궁민", "서울숲", 45)); //2
		list.add(new Person("이시언", "상도동", 41)); //4
		list.add(new Person("이제훈", "삼성동", 39)); //5
		
		// 2. add : 인덱스를 지정하여 해당 인덱스에 추가
		//			-> 내부적으로 기존에 있던 것들은 뒤로 땡기고 해당 인덱스에 값 추가
		list.add(1, new Person("유재석", "압구정", 51)); //1
		list.add(3, new Person("강호동", "도곡동", 53)); //3
		
//		list.add(1, new Person("내가다이긴당", "헤헷", 3));		// 같은 인덱스에 그 뒤에 넣을 경우 얘가 제일 앞으로 감!
		
		// 3. set : 해당 인덱스의 값을 변경
		
		list.set(3, new Person("오은영", "삼성동", 57));
		
		// 4. size : 리스트 안에 몇 개의 데이터가 있는지
		list.size();
		System.out.println("리스트 안에는 : " + list.size() + "개의 데이터가 있습니다.");
		
		// 5. remove : 해당 인덱스의 객체 삭제
		//			-> 알아서 크기가 줄어들고 뒤의 객체가 앞으로 다 땡겨옴
		list.remove(0);
		System.out.println("삭제 이후의 리스트 안에는 : " + list.size() + "개의 데이터가 있습니다.");
		System.out.println("\n리스트 \n" + list);
		
		// 6. get : 해당 인덱스의 객체 가져오기
		System.out.println(list.get(0));
		
		// 7. subList : 기존 리스트에서 원하는 만큼 추출해서 새로운 리스트 반환
		List<Person> sub = list.subList(0, 2);	// list[0], list[1]이 담김. 
		System.out.println("\nsubList : " + sub);
		
		// 8. addAll : 컬렉션을 통째로 뒤에 추가
		list.addAll(sub);
		System.out.println("sub 리스트를 addAll한 뒤의 리스트 : " + list);
		
		// 9. empty : 컬렉션이 비어있는지
		System.out.println("컬렉션이 비어있나요? : " + list.isEmpty());
		

		System.out.println("==============================================================");
		System.out.println(list + "\n\n");
		
		// 리스트에 저장된 사람들의 평균 연령
		int sum = 0;
		for (int i=0; i < list.size(); i++) {
			sum += list.get(i).getAge();
		}
		System.out.println("평균 연령 : " + sum/(list.size()));
		
		System.out.println("향상된 for문 1=====================");
		sum = 0;
		for (Person p : list) {
			sum += p.getAge();
		}
		System.out.println("평균 연령 : " + sum/(list.size()));
		
		// 저장된 사람들의 이름만 출력
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i).getName() + " ");
		}
		System.out.println();
		
		System.out.println("향상된 for문 2=====================");
		for(Person p : list) {
			System.out.println(p.getName());
		}

		// 삼성동에 사는 사람들만 출력
		System.out.println("삼성동에 사는 사람 " );
		for (int i=0; i<list.size(); i++) {
			if(list.get(i).getAddr().equals("삼성동"))
//			if(list.get(i).getAddr()=="삼성동")
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		System.out.println("향상된 for문 3=====================");
		for (Person p : list) {
			if (p.getAddr().equals("삼성동")) System.out.println(p);
		}
		
		// 정렬 (나이 순서대로 출력) => (이름 순서대로 출력)
		Collections.sort(list);		// Person 객체로 넘어가서 compareTo를 통해 
		System.out.println(list);
		
		
		// 10. clear
		list.clear();
		System.out.println("clear 후의 리스트 : " + list);
		System.out.println("컬렉션이 비어있나요? : " + list.isEmpty());
		
	}
	
	public void method3() {
		List<String> list = new ArrayList<>();
		
		list.add("banana");
		list.add("apple");
		list.add("orange");
		list.add("mango");
		list.add("grape");
		
		// 11. 오름차순 정렬 : Comparable 인터페이스를 구현하고 있는 요소를 가지고 비교한 값들 반환
		Collections.sort(list);
		System.out.println(list);
		
		// 12. 내림차순 정렬 : sort 메서드를 통해서 오름차순 정렬 후 reverse 메서드를 호출하여 정렬
		// 기존의 리스트를 거꾸로 해주는 것임. sort가 아님 !!!
		// 반드시 오름차순이 선행된 후에 reverse를 해야 내림차순 정렬로 출력이 가능
		Collections.reverse(list);
		System.out.println(list);
		
	}
}
