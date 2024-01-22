package com.kh._abstract;

import com.kh._abstract.step1.BasketBall;
import com.kh._abstract.step1.FootBall;
import com.kh._abstract.step1.Sports;
import com.kh._abstract.step2.BulgogiPizza;
import com.kh._abstract.step2.PineApplePizza;
import com.kh._abstract.step2.Pizza;
import com.kh._abstract.step2.PotatoPizza;

/*	추상 클래스 (Abstract Class)
 	
 	[접근제어자] abstract class 클래스명 {..}
 	
 	- 미완성 클래스로 추상 메서드를 포함한 클래스
 	- 미완성 클래스이기 때문에 new 연산자를 통한 객체 생성X
 	- 일반적인 멤버(변수, 메서드(+ 추상 메서드)) 포함 가능
 		- 변수 + 메서드 + 추상 메서드
 	- 객체 생성을 할 수 없지만 참조형 변수의 타입으로는 사용 가능
 	- 상속 관계로 구성되어 있으면 다형성 적용 가능
 	
 *	추상 메서드(Abstract Method)
 	
 	 [접근제어자] abstract 반환타입 메서드명(매개변수, ...); 		-- 이 뒤에 {}를 통한 코드 구현 X => 추상 메서드.
 	 
 	 - 미완성 메서드로 중괄호({})가 구현되지 않는 메서드
 	 - 추상 클래스를 상속받는 자식 클래스에서 "반드시" 오버라이딩(재정의) 해야 한다.
 	 - 오버라이딩(재정의) 해주지 않으면 컴파일 에러 발생
 	 - 자식 클래스에 강제성을 부여하는 방법 	
 	
  	*/

public class Application {

	public static void main(String[] args) {
		
		// 상속 사용 X
		BasketBall b = new BasketBall(9);
		FootBall f = new FootBall(11);
		
//		b.rule();
//		f.rule();
		
		// 상속 사용 O + 다형성을 통해 Sports의 이름으로 객체 생성
		// Sports를 추상 클래스로 변경
//		Sports s = new Sports(5); <-- 추상 클래스는 new를 통한 객체 생성이 불가능.
		Sports b2 = new BasketBall(9);
		Sports f2 = new FootBall(11);
		
//		s.rule();
		b2.rule();
		f2.rule();
		
		System.out.println();
		
		// 다형성 통해서 배열에 직접 생성
		Pizza[] pizza = {
				new BulgogiPizza(33900, "피자헛"),
				new PotatoPizza(27900, "도미노피자"),
				new PineApplePizza(11000, "잭슨피자")
		};
		
//		for(int i=0; i < pizza.length; i++) {
//			pizza[i].makePizza();
//		}

		
		// 배열/String에서 사용 가능 [향상된 for문]
		// for(타입 (변수명) : 배열명)
		for(Pizza p : pizza) {
			p.makePizza();
		}
	}

}
