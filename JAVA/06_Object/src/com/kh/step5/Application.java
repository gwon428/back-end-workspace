package com.kh.step5;

import com.kh.step5.model.Book;

public class Application {

	public static void main(String[] args) {
		Book b = new Book();
		
		// 객체 생성 시 매개변수 작성 X -> b 객체에 값이 아무것도 담겨있지 않음
		System.out.println(b);
		
		// b.title = "처음부터.. 전략"; => private 때문에 막혀있어서
		// setTitle을 통해 Application에서 값을 입력받을 수 있음
//		b.setTitle("처음부터 시작하는 주식투자 단타전략");
		
		// setTitle을 통해 책 제목을 입력받았기 때문에 제목이 출력
		System.out.println(b);
		
		// b.title 출력 => private 때문에 막혀있어서
		// getTitle을 통해 객체의 특정 변수값을 출력할 수 있게 됨
		System.out.println("title : " + b.getTitle());
		
		// getter setter 방식
		b.setTitle("처음부터 시작하는 주식투자 단타전략");
		b.setAuthor("홍인기");
		b.setPrice(21000);
		b.setDiscountRate(0.2);
		
		System.out.println(b);
		
		// 생성자 방식
		Book b2 = new Book("나는 메트로폴리탄 미술관의 경비원입니다", 17500, 0.1, "패트릭 브링리");
		System.out.println(b2);
		
		// getter를 이용하여 두 객체 각각 할인율을 적용한 책 가격을 계산해서 출력
		// 할인된 가격 = 가격 - (가격 * 할인율)
		System.out.println();
		System.out.println("<getter를 이용하여 두 책의 책 제목과 원래 가격, 할인된 가격 출력하기>");
		int discount = (int) (b.getPrice() - (b.getPrice()*b.getDiscountRate()));
		int discount2 = (int)(b2.getPrice() - (b2.getPrice() * b2.getDiscountRate()));
		System.out.println("[" + b.getTitle() + "]의 \n원래 가격 : " + b.getPrice() + "\n할인된 가격 : " + discount + "원");
		System.out.println();
		System.out.println("[" + b2.getTitle() + "]의 \n원래 가격 : " + b2.getPrice() + "\n할인된 가격 : " + discount2 + "원");
		
	}


}
