package com.kh.composite.model;

/*	클래스 간의 관계 : 상속 VS 포함
 	- 상속 관계 : ~은 ~이다. (is-a 관계)
 	- 포함 관계 : ~은 ~를 가지고 있다. (has-a 관계)
 	- 자바는 단일 상속만 허용 (C++는 다중 상속 허용)
 	- 클래스 간의 관계를 많이 맺을수록 재사용을 높이고 관리하기 쉽게 한다.
 	- 
  */

public class Customer {
	protected String name;			// 고객 이름	
	protected String grade;			// 고객 등급
	protected int bonusPoint;		// 보너스 포인트
	protected double bonusRatio;	// 포인트 적립 비율

	Product product;		// 포함 관계	(DB -..> JOIN)
	
	public Customer() {	
		System.out.println("기본 생성자로 만듦!");
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
}
