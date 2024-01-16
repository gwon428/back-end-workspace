package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

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
	
	Scanner sc = new Scanner(System.in);
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
	
	/*	3명의 키를 입력받아 배열에 저장하고 3명의 키의 평균값을 구하시오
	 * 	키 입력 > 180
	 *  키 입력 > 177.3
	 *  키 입력 > 168.2
	 *  175.2
	 * 
	 * */
	public void method3() {
		double[] nums = new double [3];	// 배열 선언 (모든 데이터타입으로 배열 선언이 가능)
		double sum = 0;
		double avg = 0;
		
		for (int i=0; i < nums.length ; i++) {
			System.out.print("키 입력 > ");
			double height = sc.nextDouble();
			
			nums[i] = height;		// 배열 값 초기화
			sum += height;
		}
		avg = sum/nums.length;
		System.out.printf("%d명의 평균 : %.1f", nums.length, avg);
	}
	
	public void method3_sol() {
		double[] arr = new double[3];			// 배열 선언 => 값을 초기화하지 않아 [0.0, 0.0, 0.0] 상태
		double sum = 0;
		
		for (int i=0; i < arr.length; i++) {		// arr[0], arr[1], arr[2]에 값을 초기화하는 반복문 설정
			System.out.print("키 입력 > ");
			arr[i] = sc.nextDouble();
			sum += arr[i];
		}
		
		System.out.printf("%d명의 평균 : %.1f\n", arr.length, sum/arr.length);
//		System.out.println(Arrays.toString(arr));		// [값1, 값2, 값3]의 형태로 배열 출력
		
	}
	
	// 배열의 복사 (배열은 주소값을 Stack 메모리에, 각각의 값들은 Heap 메모리에 저장한다)
	// 1. 얕은 복사 : 배열의 주소만 복사
		// - 같은 주소의 배열을 여러 변수가 참조
	public void method4() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = number;
		System.out.println(number);		// [I@7f63425a
		System.out.println(copy);		// [I@7f63425a
		// 두 배열의 주소값이 같음
		
		copy[1] = 20;
		System.out.println(Arrays.toString(copy));		//[1, 20, 3, 4, 5]
		System.out.println(Arrays.toString(number));	//[1, 20, 3, 4, 5]
		// 두 배열에 주는 변화가 같이 적용되는 것처럼 보임 (실제로는 같은 배열을 참조하기 때문!!)
	}
	
	// 2. 깊은 복사 : 동일한 새로운 배열을 하나 생성해서 내부 값들도 함께 복사
	// - 아예 새로운 배열을 생성 (Stack 메모리에 주소가 하나 더 생김)
	// 1) for문을 이용한 깊은 복사
	public void method5() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = new int [number.length];		// 새로운 배열 선언
		
		for (int i=0; i<number.length;i++) {
			copy[i] = number[i];
		}
		
		System.out.println(number);		//[I@7f63425a
		System.out.println(copy);		//[I@36d64342
		// 두 배열의 주소값이 다름
		
		System.out.println(Arrays.toString(copy));	
		System.out.println(Arrays.toString(number));

		copy[2] = 20;
		System.out.println(Arrays.toString(copy));	// [1, 2, 20, 4, 5]
		System.out.println(Arrays.toString(number));	// [1, 2, 3, 4, 5]
	}
	
	// 2) System 클래스에서 제공하는 arraycopy() 메서드를 이용한 깊은 복사
	//		System.arraycopy(원본배열, 복사시작인덱스, 복사본배열, 복사시작인덱스, 복사할길이);
	public void method6() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = new int [number.length];
		System.arraycopy(number, 0, copy, 0, number.length);
		
		copy[2]= 30;
		
		System.out.println(Arrays.toString(number));	// [1, 2, 3, 4, 5]
		System.out.println(Arrays.toString(copy));		// [1, 2, 30, 4, 5]
	}

	// 3) Arrays 클래스에서 제공하는 copyOf() 메서드를 이용한 깊은 복사
	//		Arrays.copyOf(원본배열, 복사본배열길이)
	public void method7() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = Arrays.copyOf(number, number.length);
		
		copy[3] = 10;
		System.out.println(Arrays.toString(number));	// [1, 2, 3, 4, 5]
		System.out.println(Arrays.toString(copy));		// [1, 2, 3, 10, 5]
	}
	
	// 4) 배열의 clone() 메서드를 이용한 깊은 복사
	public void method8() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = number.clone();
		
		copy[4] = 50;
		System.out.println(Arrays.toString(number));	// [1, 2, 3, 4, 5]
		System.out.println(Arrays.toString(copy));		// [1, 2, 3, 4, 50]
	}

	
	public static void main(String[] args) {
		A_Array a = new A_Array();
		
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method3_sol();
//		a.method4();	// 얕은 복사
//		a.method5();	// 깊은 복사 (for문)
//		a.method6();    // 깊은 복사 (System 클래스에서 제공하는 arraycopy() 메서드)
//		a.method7();	// 깊은 복사 (Arrays 클래스에서 제공하는 copyOf() 메서드)
		a.method8();	// 깊은 복사 (배열의 clone() 메서드)
	}



}
