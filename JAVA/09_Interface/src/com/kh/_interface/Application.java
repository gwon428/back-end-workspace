package com.kh._interface;

import com.kh._interface.step1.Bus;
import com.kh._interface.step1.Taxi;
import com.kh._interface.step1.Vehicle;
import com.kh._interface.step2.Audio;
import com.kh._interface.step2.Tv;

/*	인터페이스 (interface)	
 	
 	[접근제어자] interface 인터페이스명 {...}
 	
 	- 인터페이스는 개발 코드와 객체가 서로 통신하는 접점 역할을 한다
 	- 인터페이스에서 변수는 무조건 '상수'이다. (public, static, final이 생략되어 있음)
 	- 인터페이스에서 메서드는 무조건 '추상 메서드'이다.
 	- 객체가 구현해야 하는 기능이 있을 때 인터페이스에 추상 메서드를 추가해서 객체가 기능을 구현하도록 만들 수 있다.
 	- 인터페이스를 구현하려면 implements 키워드를 사용한다.
 	- (상속은 단일 상속만 가능하나) 인터페이스는 다중 상속(구현)이 가능하다. [implements 뒤에 여러 개가 올 수 있음!]
 	- 추상 클래스보다 더 강한 규칙성, 강제성을 가진 것이 인터페이스다.
 	
 *	추상 클래스와 인터페이스 비교
 >	공통점 <
 	 - 객체 생성은 안 되나, 참조 변수로는 사용이 가능하다. (즉, 다형성 적용 가능)
 	 - 상속(구현)하는 클래스에서 추상 메서드를 재정의하도록 강제한다.
 > 차이점 <
 	- 추상 클래스는 abstract 키워드로 클래스가 정의되어 있고 클래스 내에 변수, 메서드 생성 가능
 		인터페이스는 interface 키워드로 정의되어 있고 인터페이스 내에 변수(상수), 메서드(추상 메서드) 생성 불가능
 						- 인터페이스에서 지정한 변수는 상수, 메서드는 추상 메서드 (?
 
 * extends와 implements
 	- 클래스 간의 상속 관계일 때 : 자식 클래스명 extends 부모 클래스명
 	- 클래스와 인터페이스의 구현 관계일 때 : 구현 클래스명 implements 인터페이스명, 인터페이스명, ....
 	- 인터페이스 간의 상속 관계일 때 : 인터페이스명 extends 인터페이스명, 인터페이스명, ...
 	
 */

public class Application {

//	Vehicle v = new Vehicle();	=> 인터페이스도 객체 생성이 X

	public static void main(String[] args) {
		Vehicle bus = new Bus(); // 참조 변수로는 가능
		Vehicle taxi = new Taxi();

		bus.run();
		taxi.run();

		System.out.println();
		bus.turn();
		taxi.turn();
		
		System.out.println("Step2");
		System.out.println();
		
		System.out.println("===== Tv =====");
		Tv tv = new Tv();
		tv.turnOn();
		tv.setVolume(-1);		// 최소 볼륨을 0으로 설정했기 때문에 0으로 출력
		tv.turnOff();
		
		System.out.println();
		
		System.out.println("===== Audio =====");
		Audio audio = new Audio();
		audio.turnOn();
		audio.search("melon.com");
		audio.setVolume(30);		// 최대 볼륨을 10으로 설정했기 때문에 10으로 출력
		audio.turnOff();

		/*	추상 클래스 == 미완성 설계도
		 	인터페이스 == 기본 설계도
		 	
		 	[개발방법론]
		 	예전 - 폭포수
		 		-> 순차적 (기획 100% -> 디자인 100% -> 개발 100%)
		 	최근 - 애자일
		 		-> 순환 (기획 -> 디자인 -> 개발 -> 기획 -> 디자인 -> ... -> 개발 -> ... )
				 	==> 인터페이스의 사용성이 점점 줄어들고 있음 (유지/보수를 하다보면 수정이 잦아짐) 
				 	=> 인터페이스 지정 후 애자일 방식 -> 인터페이스도 수정하고, 클래스도 수정하게 되기 때문
		*/
		
	}
	
}
