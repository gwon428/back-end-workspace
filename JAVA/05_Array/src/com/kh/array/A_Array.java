package com.kh.array;

public class A_Array {

	/*
	 * 변수와 배열의 차이
	 * 
	 * - 변수 : 하나의 공간에 하나의 값을 담음
	 * - 배열 : 하나의 공간에 "여러 개의 값"(같은 자료형의 값들)을 담음
	 * 
	 * 	1. 배열의 선언
	 * 	자료형[] 배열명;
	 * 	or
	 * 	자료형 배열명[];
	 * 
	 * 	- 배열을 선언한다고 해서 값을 저장할 공간이 생성되는 것이 아니라 배열을 다루는 데 필요한 변수가 생성
	 * 
	 * 
	 * 	2. 배열의 초기화 (반드시 필요) [배열이 어느 정도 크기를 가지고 있는지 세팅을 해줘야 함]
	 * 	배열명 = new 자료형[배열크기];
	 * 
	 * 	- 생성된 배열에 처음으로 값을 저장 == 초기화
	 * 
	 * 	3. 배열의 선언과 초기화 동시 진행
	 * 	자료형[] 배열명 = new 자료형[배열크기];
	 * 	자료형 배열명[] = new 자료형[배열크기];
	 */
	
	
	// 배열의 생성과 초기화
	public void method1() {
		System.out.println("초기화 전 =========");
		int[] nums = new int[5];		// 배열 크기를 지정하지 않으면 에러 발생
		// 스택 (기본 자료형) 힙 (참조 자료형)
		
		// [int는 기본값이 0이기 때문에 배열 생성만 하고 초기화를 하지 않으면 모든 값이 0으로 채워짐]
		// 배열 생성하고 해당 값들은 초기화하지 않은 상태 -> 기본값 0이 들어간 것 확인
		// 정수형 : 0, 실수형 : 0.0, 문자형 : \u0000, 논리형 : false, 참조형 : null
		for (int i=0; i<5; i++) {
			System.out.println(nums[i]);
		}
		
		System.out.println("초기화 후 =========");
		nums[0] = 100;
		nums[1] = 70;
		nums[2] = 90;
		nums[3] = 80;
		nums[4] = 60;
		
		for (int i=0; i<5; i++) {
			System.out.println(nums[i]);
		}
	}
	
	// 배열 선언과 동시에 값들 초기화
	
	public void method2() {
		int[] nums = {100, 70, 90, 80, 60};
		for(int i=0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	
	
	public static void main(String[] args) {
		A_Array a = new A_Array();
		
//		a.method1();
		a.method2();
	}



}