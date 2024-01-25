package com.kh.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.map.model.Snack;

/*	Map
 	- key-value 쌍으로 저장
 	- 순서 없음
 	- 중복 : 키(key) X
 			값(value) O
 	
 	HashMap
 	- Map 인터페이스를 구현한 대표적인 컬렉션 클래스
 	
 */
public class A_HashMap {

	public static void main(String[] args) {
		A_HashMap a = new A_HashMap();
//		a.method1();
		a.method2();
	}

	public void method1() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("웨하스", 250);
		map.put("고래밥", 180);
		map.put("칸쵸",  800);
		map.put("나쵸", 450);
		
		System.out.println(map);
		
		// 1. 키만 가져오기
		Set<String> key = map.keySet();	// Set은 중복 허용 x => key값은 중복이 안되기 때문에
		System.out.println(key);
		
		// 2. 값만 가져오기
		Collection<Integer> col = map.values();	// 컬렉션으로 가져옴
		System.out.println(col);
		
		// 3. 키에 해당하는 value 값 가져오기
		Iterator<String> it = key.iterator();
		while(it.hasNext()) {
			String name = it.next();		// 키 하나씩 가져오기	[Iterator 내에서 next()는 한번만 진행되어야 함]
			System.out.println(name + " : " + map.get(name));
		}
		
		//?
		for(String s : key) {
			System.out.println(s + " : " + map.get(s));
		}
		
		/*	4. entrySet 메서드
		 	- Map 컬렉션에 있는 Entry 객체(Entry : key, value 쌍으로 이루어진)를 Set 컬렉션에 담아서 반환
		 	- 반환된 Set 컬렉션에서 반복자를 얻어서 반복 처리
		 	[가상의 entry 객체로 억지로 끼워맞춘]
		 */
		System.out.println("entrySet 메서드 ==============================");
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		System.out.println(entrySet);
		
		for(Entry<String, Integer> e : entrySet) {
		// 객체로 만들어서 e.get(i)를 통해 값과 키를 따로 뽑아낼 수 있음.
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
	
	public void method2() {
		Map<String, Snack> map = new HashMap<String, Snack>();
		// put -> 1. 추가 + 2. 수정
		map.put("웨하스", new Snack("치즈", 240));
		map.put("웨하스", new Snack("딸기", 255));
		map.put("고래밥", new Snack("양념치킨", 173));
		map.put("자유시간", new Snack("아몬드", 232));
		map.put("칸쵸", new Snack("딸기요거트", 880));
		map.put("홈런볼", new Snack("초코", 270));
		map.put("스윙칩", new Snack("볶음고추", 347));
		map.put("나쵸", new Snack("치즈", 486));
		map.put("꼬깔콘", new Snack("매콤달콤", 175));
		map.put("후렌치파이", new Snack("딸기", 900));
		
		System.out.println(map.size());

		// 웨하스에는 뭐가 들어 있을까요 ?
		System.out.println(map.get("웨하스"));
		System.out.println(map);
		
		// 키 값으로 삭제하기 - 꼬깔콘
		map.remove("꼬깔콘");
		System.out.println(map);
		
		System.out.println("\n\n연습문제================================================");
		
		// 1. 홈런볼에 대한 과자 정보 출력
		System.out.println(map.get("홈런볼"));
		
		// 2. 후렌치 파이의 맛 정보 출력
		System.out.println(map.get("후렌치파이").getFlavor());
		
		// 3. 모든 과자의 칼로리 총합과 평균 출력
		int sum = 0;

		// Entry, 향상된 for문
//		Set<Entry<String, Snack>> entrySet = map.entrySet();
//		
//		for (Entry<String, Snack> e : entrySet) {
//			Snack snack = e.getValue();
//			sum += snack.getCalorie();
//		}
		
		// map.keySet()
		for (String key : map.keySet()) {
			Snack snack = map.get(key);
			sum += snack.getCalorie();
		}
		
		// map.values()
		for(Snack s : map.values()) {
			sum += s.getCalorie();
		}
		
//		System.out.println(entrySet);
		System.out.println("칼로리 합 : " + sum);
		System.out.println("칼로리 평균 : " + (sum / map.size()));
		
		// 모든 Entry 객체 삭제
		map.clear();
		System.out.println("비어있는지 : " + map.isEmpty());
		System.out.println(map);
	}
}
