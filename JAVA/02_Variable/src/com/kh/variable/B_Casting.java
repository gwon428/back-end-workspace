package com.kh.variable;

public class B_Casting {
	
	/*	형 변환(Casting)
	 * 
	 * 	- 값의 타입을 다른 타입으로 변환하는 것
	 * 	- boolean을 제외한 7개의 기본형은 서로 형변환이 가능
	 * */
	public static void main(String[] args) {
		B_Casting b = new B_Casting();
//		b.autoCasting();
		b.casting();
	}
	
	// 자동 형 변환(묵시적 형 변환)
	// - 자동으로 형 변환이 이루어지기 때문에 따로 형 변환하지 않아도 된다.
	public void autoCasting() {
		// 정수
		byte b = 10;	// 1byte
		short s = b;	// 2byte : byte -> short 자동 형 변환
		int i = s;		// 4byte : short -> int 자동 형 변환
		long l = i;		// 8byte : int -> long 자동 형 변환
		
		// 실수
		float f = 1;	// 4byte
		double d = f;	// 8byte : float -> double
		
		// 정수 -> 실수 가능!
		d = i;	// int -> double
		
		f = l;	// 8byte(long) -> 4byte(float)
			// => 표현 가능한 수의 범위가 더 크기 때문에 가능 (byte 크기와 별개)
		
		double result = 12 + 3.3;
		System.out.println(result);		// 15.3
		
		int result2 = b + s;			// byte, short 타입의 데이터는 연산시 무조건 int 타입으로 변환 (int가 기본 type이기 때문)
		System.out.println(result2);	// 20
		
		long result3 = 30 + 30;			// 30 + 30 = 60 (int형인 상태에서 연산을 먼저 하고), 60을 long 타입으로 형 변환 (60L)
		System.out.println(result3);	// 60
		
		long result4 = 30 + 30L;		// 30L + 30L = 60L (int형과 long을 연산하려면 long + long으로 변환 후 연산)
		System.out.println(result4);	// 60
	}
	
	/*	강제 형 변환 (명시적 형 변환)
	 * 
	 * 	(자료형) 데이터;
	 * 
	 * 	- 범위가 큰 크기의 자료형의 데이터를 작은 크기의 자료형으로 변환하려고 할 때 사용 
	 * 	- 강제 형 변환의 경우 데이터의 손실이 발생할 수 있다.
	 * 
	 * */
	public void casting() {
		double d = 4.12345678901234567890;		// 20자리
		System.out.println(d);					// 4.123456789012345
		
		float f = (float) d;		// 6자리
		System.out.println(f);		// 4.123457
		
		int i = (int) f;
		System.out.println(i);		// 4
		
		int sum = (int)(i + d);		// 4.0 + 4.123456789012345 의 형태로 계산, 8.123456789012345에서 int 형 변환. 
		System.out.println(sum);	// 8
		
		int sum2 = i + (int) d;		// 4.123456789012345가 (int)형으로 형 변환되어 4 + 4의 형태로 연산.
		System.out.println(sum2);	// 8
		
		int number = 128;
		byte bNumber = (byte) number;
		System.out.println(bNumber);	// -128
		
		int number2 = 129;
		byte bNumber2 = (byte) number2;
		System.out.println(bNumber2);	// -127
		
		// char <-> int : 각 문자들마다 고유한 숫자가 지정되어 있기 때문에 (ex. 유니코드, 아스키코드) 쌍방향으로 형 변환 가능
		// char는 2byte. 음수값 저장 불가 => 값의 범위가 0 ~ 65535
		// int는 4byte지만 음수값을 쓸 수 없으니 char와 크기가 같아서.
		
		int num = (int)'A';			// 사실 자동 형 변환이 되기 때문에 생략 가능
		int num2 = 'A';
		System.out.println(num);
		System.out.println(num2);
		
		char ch = 52143;
		System.out.println(ch);		// 52143 -> 쮯
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
