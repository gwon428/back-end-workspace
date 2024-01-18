package com.kh.overriding.model;

public class VIPCustomer extends Customer {
	private double saleRatio;		// 할인율

	public VIPCustomer(String name) {
		this.name = name;
		this.grade = "VIP";
		this.bonusRatio = 0.05;
		this.saleRatio = 0.1;
		
	}
	
	public double getSaleRatio() {
		return saleRatio;
	}

	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}

	// 
	@Override
	public String toString() {
		return "VIPCustomer [saleRatio=" + saleRatio + ", name=" + name + ", grade=" + grade + ", bonusPoint="
				+ bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}

	/*	오버라이딩(overriding)
	 	- 자식 클래스가 상속받은 부모 클래스의 메서드를 재정의하는 것
	 	
	 	오버라이딩의 조건
	 	- 부모 클래스의 메서드명, 매개변수, 리턴타입 모두 동일		(오버로딩은 메서드명만 일치)
	 	- 접근 제어자를 좁은 범위로 변경할 수 없다.		(큰 범위로는 변경이 가능)
	 		(public > protected > default > private)
	 		-> 부모 클래스 메서드가 protected -> 범위가 같거나 넓은 protected나 public으로만 변경 가능
	 	
	 	@Override 어노테이션
	 	-명시하지 않아도 오버라이딩 O
	 	- 어노테이션을 붙이는 이유
	 	  1) 해당 메서드가 오버라이딩 된 메서드라는 것을 컴파일러에게 알려주는 역할
	 	  2) 자식 메서드에서 재정의를 잘못한 경우 컴파일 에러 표시 (실수 방지용)
	 */
	
	@Override // Customer에서 만든 calcPrice 메서드를 VIPCustomer에서 재정의
	public int calcPrice(int price) {
		this.bonusPoint += price*bonusRatio;
		return price - (int)(price*saleRatio);
	}
	
	
}
