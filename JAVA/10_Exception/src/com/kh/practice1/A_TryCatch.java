package com.kh.practice1;

public class A_TryCatch {
	/*	컴파일 에러(compile-time error) : 컴파일 시에 발생하는 에러
	 	(실행도 전에 에러가 발생해서 Run code가 진행되지 X)
	 **	런타임 에러(runtime error) : 실행 시에 발생하는 에러
	 	(실행하고 코드가 진행이 된 후에 에러가 발생)
	 *	논리적 에러(logical error) : 실행은 되지만, 의도와 다르게 동작
	 
	 
	 *	런타임 에러 종류 (2)
		- 에러 (error) : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
		- 예외 (exception) : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
		
		- 에러는 메모리 부족(OutOfMemoryError)이나, 스택오버플로우(StackOverFlowError)와 같이 일단 발생하면 복구할 수 없는 심각한 오류
			=> 폐기하는 것이 더 빠름
		- 예외는 발생하더라도 수습될 수 있는 비교적 덜 심각한 것 
	 
	 	Object
		 	-> Throwable (하위 객체)
		 	 	-> Exception (하위 객체) / Error
	 	
	 *	자바에서 제공하는 오류에 대한 전체 클래스
	 	Throwable - Error / Exception
	 	Exception - IOException - FileNotFoundException, SocketException
	 				RuntimeException - ArithmeticException, IndexOutofBoundsException
	 				
	 	[예외처리]
	 *	try ~ catch 문
	 	
	 	try {
	 	
	 		// 예외가 발생할 가능성이 있는 코드들
	 		 * 
	 	} catch(예외클래스 예외변수명) {
	 		
	 		// try에서 예외가 발생하면 실행을 멈추고 catch로 들어와서 예외 처리 코드를 실행
	 		 	// 예외가 발생하지 않으면 실행 X
	 		
	 	} (선택)[finally {
	 	
	 		// 예외가 발생하든 발생하지 않든 무조건 실행되는 코드들
	 		// close().. (finally는 주로 "자원을 반납"하는 코드가 들어감) --> (뒤에) IO(Input/Output)Exception
	 		 
	 	}]
	 	
	 */
	public static void main(String[] args) {
		
//		throw new Exception();	// 예외 발생
		
		try {
			
			throw new Exception();		// 고의로 예외 발생!
			
		} catch(Exception e) {
			
//			e.printStackTrace();					// 붉은 색의 오류 출력 => 이 코드를 주석 처리할 시 아무것도 출력되지 않음.
			System.out.println(e.getMessage());		// null (Exception이 아무것도 지정하고 있지 않기 때문에)
			
			// printStackTrace() : 예외 발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메세지를 화면에 출력
			// getMessage() : 발생한 예외 클래스의 객체에 저장된 메세지를 얻을 수 있음
			
		}
		
	}

}
