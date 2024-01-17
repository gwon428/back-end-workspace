package com.kh.step4.model;

public class Car {
	
	/*	
	 * 	접근제어자 (access modifier) : public, protected, default, private 
	 	- 클래스, 변수, 메서드, 생성자에 사용되어 외부로부터 접근을 제한
	 	
	 	// [클래스다이어그램에서의 표시] 접근제어자
	 	
	 	[+] public : 접근 제한이 전혀 없음
	 	[#] protected : '같은 패키지 내'에서, 그리고 '다른 패키지의 자손 클래스'에서 접근 가능
	 	[ ] default : '같은 패키지' 내에서만 접근 가능 (접근 제어자를 명시하지 않은 상태)
	 	[-] private : '같은 클래스' 내에서만 접근 가능
	 	
	 *	접근 제어자를 사용하는 이유 (보호, 감추기)
	 	- 외부로부터 데이터를 보호하기 위해서
	 	- 외부에서는 불필요하고, 내부적으로만 사용되는 부분을 감추기 위해서
	 */
	
	// 본디 변수는 private로 선언해야 함
	private String color;		// 색상
	private String gearType;		// 자동 or 수동
	private int door;			// 문의 개수
	
	/*	생성자
	 	- 객체가 생성될 때마다 호출되는 '인스턴스 초기화 메서드'
	 	- 변수의 초기화 또는 객체 생성 시 수행할 작업에 사용
	 	
	 *	클래스명[(=메서드명)] (타입 변수명, 타입 변수명, ...){
	 		// 객체 생성 시 수행될 코드
	 		// 주로 변수의 초기화 코드 작성!
	 	}
	  
	  * 생성자 작성 시 주의!
	  	- 반드시 생성자명은 클래스명과 동일 (대/소문자 구분)
	  	- 반환형이 존재하지 않음 --> 만약 반환형을 쓰게 되면 메서드로 인식
	  	
	  *	기본 생성자 (default constructor)
	  	- [클래스명 x = new 클래스명();]
	  	- 매개변수가 없는 생성자
	  	- 클래스에 생성자가 하나도 없으면 컴파일러가 기본 생성자를 추가
	  	- 생성자가 하나라도 있으면 컴파일러는 기본 생성자를 추가하지 않음 [ => 생성자가 여러 개 올 수 있다!!]
	  */
	// 생성자 오버로딩!
	// 기본 생성자
	public Car() {}
	
	// 생성자 (매개변수를 넣어 생성자로 값을 받아올 수 있음)
	public Car(String color, String gearType, int door) {
		/* this : 자신을 가리키는 참조변수.
		 	- 객체 주소가 저장되어 있음
		 	- 모든 인스턴스 메서드에 지역변수로 숨겨진 채 존재
		*/
		
		// 밖에서 가져온 값들을 해당 클래스 내의 값(?)들에 저장
		//this.color = color;
		//this.gearType = gearType;
		this(color, gearType);	// 하단에 생성한 생성자한테 가서 그 주소값을 받아옴..?
		this.door = door;
	}
	
	public Car(String color, String gearType) {
		this.color = color;
		this.gearType = gearType;
		door = 2;		// 해도 되고, 안 해도 되는 (매개변수로 받지 않을 때의 기본값을 지정하는 형태로 보이기도)
	}


	
	
	/*	Class Object (최상위 조상 클래스)
	  	- Object 객체가 이미 가지고 있는 메서드들은 다른 객체들도 사용 가능
	  	- 메서드 호출 형식 (ex. toString, hashCode .. etc)
	 */
	
	// 오버라이딩 발생
	// 오버라이딩 : 부모/조상 클래스(객체)의 메서드를 재정의!함
	// toString : 
//	public String toString() {
//		return "색상 : " + color + ", 변속기 : " + gearType + ", 문의 개수 : " + door;
//	}
	
	// 우클릭 -> Source => Generate toString() -> 자동으로 만들어줌
	@Override
	public String toString() {
		return "Car [color=" + color + ", gearType=" + gearType + ", door=" + door + "]";
	}
	
	
}
