package com.kh.overriding;

import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VIPCustomer;

public class Application {

	
	
	public static void main(String[] args) {
		
		Customer customer1 = new Customer("이상현");
		Customer customer2 = new Customer("이상호");
		
		// toString을 오버라이딩하기 전에는 주소값으로 출력 => 이름이 같아도 두 개의 주소값이 다름 => 객체 생성을 두 번에 걸쳐서 했기 때문에 같은 이름의 고객 두 명이라고 보면 됨
		System.out.println(customer1);
		System.out.println(customer2);
		
		System.out.println(customer1 == customer2);
		
		// equals도 Object에 있기 때문에 재정의를 할 수 있음 -> Customer 파일에서 재정의
		System.out.println(customer1.equals(customer2));		// false (이름으로 구분)
		
		VIPCustomer customer3 = new VIPCustomer("정세영");
		VIPCustomer customer4 = new VIPCustomer("정회영");
		
		System.out.println();
		// Customer에서 재정의했지만, VIPCustomer는 Customer를 상속받기 때문에 true!
		System.out.println(customer3.equals(customer4));		// true
		
		// customer1 또는 customer2
		// customer3 또는 customer4
		// ~~님의 등급은 ~~이며, 지불해야 하는 금액은 calcPrice()원이며, 적립된 포인트는 ~~점입니다.
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다.\n",
						customer1.getName(), customer1.getGrade(), customer1.calcPrice(10000), customer1.getBonusPoint());
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다.\n",
				customer2.getName(), customer2.getGrade(), customer2.calcPrice(10000), customer2.getBonusPoint());
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다.\n",
				customer3.getName(), customer3.getGrade(), customer3.calcPrice(10000), customer3.getBonusPoint());
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다.\n",
				customer4.getName(), customer4.getGrade(), customer4.calcPrice(10000), customer4.getBonusPoint());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
