package com.kh.lambda;

/*	함수적 인터페이스 (Functional Interface)
 	- 단 하나의 추상 메서드만 선언된 인터페이스
 	[보통 추상 메서드 여러 개, 상수들을 포함하지만, 함수적 인터페이스는 추상메서드 '한 개만' 올 수 있음.]
 	- @FunctionalInterface 어노테이션을 붙여서 두 개 이상의 추상 메서드가 선언되지 않도록 컴파일 체크를 한다.
 	[함수적 인터페이스로 어노테이션을 통해 선언 => 추상 메서드가 없거나, 여러 개일 때 오류를 보여주면서 확인하도록 유도]
 	
 	표준 함수적 인터페이스
 	- java.util.function 표준 API 패키지로 제공
 	- 용도에 따라 Consumer, Supplier, Function, Operator, Predicate로 구분
 */

@FunctionalInterface 
public interface MathInterface {
	
	// 추상 메서드 1개! => 추상 메서드는 실행 {}이 없음 [주의할 것]
	public int calc(int a, int b);
	
}

