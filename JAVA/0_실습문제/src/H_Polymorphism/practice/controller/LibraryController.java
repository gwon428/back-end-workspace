package H_Polymorphism.practice.controller;

import H_Polymorphism.practice.model.AniBook;
import H_Polymorphism.practice.model.Book;
import H_Polymorphism.practice.model.CookBook;
import H_Polymorphism.practice.model.Member;

public class LibraryController {
	private Member member = null;
	private Book[] bookList = new Book[4];
	
	// 인스턴스 초기화 블록 : 객체 생성시 실행되는 블록
 	{
 		bookList[0] = new CookBook("맛있는 지중해식 레시피", true);
 		bookList[1] = new CookBook("카페 샌드위치 마스터 클래스", false);
 		bookList[2] = new AniBook("원피스 107", 19);
 		bookList[3] = new AniBook("주술회전 24", 15);
 	}
 	
 	public void setMember(String name, int age) {
 		// member가 null이기 때문에 새로운 멤버 객체를 생성해야 함.
 		member = new Member();
 		
 		member.setName(name);
 		member.setAge(age);
 	}
 	
 	public Member info() {
 		return member;
 	}
}
