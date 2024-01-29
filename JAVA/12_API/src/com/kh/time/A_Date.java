package com.kh.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class A_Date {

	public static void main(String[] args) {
		A_Date a = new A_Date();
//		a.method1();		// Date
		a.method2();		// Calendar
	}

	/*	Date
	 	- java.util 패키지에 속한, 날짜와 시간을 다룰 목적으로 만들어진 클래스 (JDK 1.0)
	 	- Date의 메서드는 대부분 deprecated(비권장) 되어있지만 여전히 사용
	 */
	public void method1() {
		
		// 기본 생성자로 객체를 생성하면 현재 시스템의 시간에 대한 정보를 가지고 객체를 생성한다.
		Date today = new Date();
		System.out.println(today);		// 오늘 날짜 출력
		
		Date when = new Date(0);
		System.out.println(when);		//	Thu Jan 01 09:00:00 KST 1970
		
		System.out.println("getTime : " + today.getTime());

		// Deprecated 된 기능들
		System.out.println("getYear : " + (today.getYear() + 1900) + "년");
		System.out.println("getMonth : " + (today.getMonth() + 1) + "월");
		System.out.println("getDate : " + today.getDate() + "일");
		System.out.println("getHours : " + today.getHours() + "시");
		System.out.println("getMinutes : " + today.getMinutes() + "분");
		System.out.println("getSeconds : " + today.getSeconds() + "초");
		
		// SimpleDateFormat : 날짜 데이터를 원하는 형태로 출력할 수 있도록
		System.out.println("simpleDateForma==========================================");
		// H : 0~23, h : 1~12
		// 2024년 1월 26일 (금) 오후 4시 25분 30초
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) a hh시 mm분 ss초");
		String formatDate = sdf.format(today);
		System.out.println(formatDate);
		
	}
	
	/*	Calendar
	 	- Date 클래스를 개선한 추상 클래스 (JDK 1.1)
	 	- 여전히 단점이 존재
	 	
	 	싱글톤 패턴으로 생성
	 */
	public void method2() {
		
		/*	1. 추상 클래스이기 때문에 직접 객체 생성할 수 없다.
		 	2. getInstance() 메서드로 Calendar 클래스를 구현한 클래스의 객체를 반환
		 	3. [반환된 클래스의 객체 그대로 사용할 수 없기 때문에] 
		 		태국 - BuddhistCalendar, 그 외 - GregorianCalerdar 를 통해 객체를 생성
		 */
		
//		Calendar cal = new Calendar();		// 추상 메서드가 추가되어 있기 때문에 구현 X => 객체 생성 X
		Calendar today = Calendar.getInstance();		// getInstance() 메서드를 통해
		today = new GregorianCalendar();
		
		System.out.println(today);
		
		// 년, 월, 일, 시, 분, 초
		System.out.println("YEAR : " + today.get(Calendar.YEAR) + "년");
		System.out.println("MONTH : " + (today.get(Calendar.MONTH) +1) + "월");		// 월은 0부터 시작하기 때문에 연산자 우선순위를 주의해서 +1를 해줄 것
		System.out.println("DATE : " + today.get(Calendar.DATE) + "일");
		System.out.println("HOUR : " + today.get(Calendar.HOUR) + "시");					// 0~11시
		System.out.println("HOUR_OF_DAY : " + today.get(Calendar.HOUR_OF_DAY) + "시");	// 0~23시
		System.out.println("MINUTE : " + today.get(Calendar.MINUTE) + "분");
		System.out.println("SECOND : " + today.get(Calendar.SECOND) + "초");
		
		
		System.out.println("=========================================날짜 지정===========================================");
		
		//날짜 지정
		Calendar date = Calendar.getInstance();
		date.set(2024, Calendar.MAY, 16);		// 월을 5월로 설정할 시 출력하면 6월로 나옴 (calendar.month +1)과 같은 이유
		System.out.println(date.getTime()); 
		
		// SimpleDateFormat 클래스 사용!
		// 24-05-16 09:25:30
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String formatDate = sdf.format(date.getTime());			// .getTime();
		System.out.println(formatDate);
	}
	
}
