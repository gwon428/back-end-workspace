package com.kh.map;

import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class B_Properties {

	/*	Properties (프로퍼티)
	 	- HashMap 구버전인 Hashtable(Object, Object)을 상속받아 구현한 것
	 	- (String, String) 형태로 단순화된 컬렉션 클래스
	 	- 주로 환경설정과 관련된 속성(property)을 저장하는 데 사용
	 */
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		// Map의 특징 : 키값 중복 X, 순서 X
		prop.setProperty("List", "1. ArrayList");
		prop.setProperty("Set", "3. HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "2. Properties");
		
		System.out.println(prop);

		Enumeration en = prop.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();	// 반환이 Object이기 때문에 (String)으로 형 변환.
			String value = prop.getProperty(key);
			System.out.println(key + " : " + value);
		}
		System.out.println();
		
		Set<Entry<Object, Object>> entrySet = prop.entrySet();
		for(Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
