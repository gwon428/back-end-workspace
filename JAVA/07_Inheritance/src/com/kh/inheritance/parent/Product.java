package com.kh.inheritance.parent;

/*	모든 클래스는 Object 클래스의 후손이다.
 	즉, 최상위 클래스는 항상 Object이다.
 	=> Object 클래스에 있는 모든 메서드를 사용할 수 있다.
 
 */

// 3개의 클래스 모두 공통적으로 가지고 있는 요소만 추출하여 부모 클래스를 만든다.
public class Product {
	
	private String brand;		// 브랜드
	String pCode;		// 상품 코드
	protected String name;		// 상품명
	public int price;			// 가격
	
	// 기본 생성자
	public Product() {
		
	}
	
	// 오버로딩과 오버라이딩의 차이
	// @오버로딩
	// 생성자
	public Product(String brand, String pCode, String name, int price) {
		this.brand = brand;
		this.pCode = pCode;
		this.name = name;
		this.price = price;
	}

	// getter setter => 값을 담는 방법 2
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// toString
	@Override // 오버라이딩 : 부모 객체에 있는 것을 재정의
	public String toString() {
		return "Product [brand=" + brand + ", pCode=" + pCode + ", name=" + name + ", price=" + price + "]";
	}

}
