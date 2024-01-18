package com.kh.overriding.model;

public class Customer {
	
	// protected : 자식 객체에서 바로 접근할 수 있게 
	protected String name;			// 고객 이름	
	protected String grade;			// 고객 등급
	protected int bonusPoint;		// 보너스 포인트
	protected double bonusRatio;	// 포인트 적립 비율

	public Customer() {	
	}

	public Customer(String name) {
		this.name = name;
		this.grade = "SILVER";
		this.bonusRatio = 0.01;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", grade=" + grade + ", bonusPoint=" + bonusPoint + ", bonusRatio="
				+ bonusRatio + "]";
	}
	
	@Override	// <-- 어노테이션! '이 메서드는 재정의된 메서드이다.' 라고 명확히 알려주는 역할
	public boolean equals(Object obj) {
		Customer c = (Customer) obj;		// Object obj를 Customer로 형변환해서 Customer로 만드는 형식		
											// 다형성!과 관련
		return this.name == c.name;
	}
	
	public int calcPrice(int price) {
		// 보너스 포인트 계산!
		this.bonusPoint += price*bonusRatio;
		return price;
	}
	
}
