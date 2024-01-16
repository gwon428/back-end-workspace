package com.kh.array;

import java.util.Arrays;

public class B_Dimension {
	
	/*	다차원 배열 : '[]의 개수가 차원의 수를 의미
	 * 
	 * 	1. 2차원 배열의 선언
	 * 		자료형[][] 배열명;
	 * 		or
	 * 		자료형 배열명[][];
	 * 		or
	 * 		자료형[] 배열명[];
	 * 
	 * 	2. 2차원 배열의 생성
	 * 
	 * 		배열명 = new 자료형[행크기][열크기];
	 * 
	 * 	3. 2차원 배열의 선언과 초기화를 동시 진행
	 * 
	 * 		자료형[][] 배열명 = new 자료형[행크기][열크기];
	 * 		
	 * 	4. 2차원 배열의 초기화
	 * 
	 * 		배열명[0][0] = 값;
	 * 		배열명[0][1] = 값;
	 * 		...
	 * 
	 * */
	
	// 선언과 동시에 초기화
	public void method1() {
		int[][] arr = {{1, 2, 3, 4, 5},
						{6, 7, 8, 9, 10},
						{11, 12, 13, 14, 15}};
		
		// [1, 2, 3, 4, 5]
		// [6, 7, 8, 9, 10]
		// [11, 12, 13, 14, 15]
		
		for (int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		// arr이라는 배열에 (배열이라는) '값'이 3개 들어있다고 보면 됨
		
		System.out.println("값들을 하나씩 출력 ====================");
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.println((arr[i][j]));	
				// 값..을 출력하는데 얘는 왜 Arrays.toString(arr[i][j])가 안되는지 => Arrays.toString(A) => A에는 배열만 올 수 있기 때문에 현재 arr[i][j]는 int값이라서!
			}
		}
		
		
		// 향상된 for문
		System.out.println("향상된 for문========================");
		for (int[] i : arr) {
			System.out.println(Arrays.toString(i));
			for (int j : i) {
				System.out.println(j);
			}
		}
	}
	
	// 가변 배열 : 다차원 배열에서 마지막 차수의 크기를 지정하지 않고 다르게 지정
	/*	[HTML, CSS, JavaScript]
	 * 	[MySQL, JAVA, JDBC, Servlet, JSP]
	 * 	[jQuery, Mybatis, Spring]
	 * 	[Spring Boot, React]
	 * 
	 * */

	public void method2() {
		String [][] arr = {{"HTML", "CSS", "JavaScript"},
							{"MySQL", "JAVA", "JDBC", "Servlet", "JSP"},
							{"jQuery", "Mybatis", "Spring"},
							{"Spring Boot", "React"}};
		
		for (String[] i : arr) {
			System.out.println(Arrays.toString(i));
		}
		
		System.out.println("하나씩 출력 ===============================");
		for(String[]i : arr) {
			for (String j : i) {
				System.out.println(j);
			}
			System.out.println("다음 과정");
		}
	}
	public static void main(String[] args) {
		B_Dimension b = new B_Dimension();
		
//		b.method1();
		b.method2();
	}

}
