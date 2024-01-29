package com.kh.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*	java.time 패키지
 	- Date와 Calendar의 단점을 개선한 새로운 클래스들을 제공 (JDK 1.8 == java8)
 	- LocalDate, LocalTime, LocalDateTime, ZonedDateTime 클래스 등 포함
 	- 날짜와 시간에 대한 다양한 메서드를 제공
 */

public class B_Time {

	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		B_Time b = new B_Time();
//		b.method1();		// LocalDateTime, ZonedDateTime, LocalDate, LocalTime
//		b.method2();		// Period, Duration
		b.method3();		// sol
//		b.method3_my();
	}
	
	public void method1() {
	//	LocalDateTime: 날짜와 시간 정보를 모두 저장

		
		LocalDateTime now = LocalDateTime.now();
		// static 메서드로 다 제공하고 있기 때문에 그대로 사용할 수 있음
		
		System.out.println("today : " + now);
		
		// 날짜 지정
		LocalDateTime when = LocalDateTime.of(2024, 5, 16, 17, 50, 00);
		System.out.println("when : " + when);
		
	//	ZonedDateTime : LocalDateTime + 시간대
		System.out.println("ZonedDateTime : " + ZonedDateTime.now());
		
		// 년, 월, 일, 요일, 시, 분, 초
		System.out.println(now.getYear() + "년");
		System.out.println(now.getMonth());					// JANUARY
		System.out.println(now.getMonthValue() + "월");
		System.out.println(now.getDayOfMonth() + "일");
		System.out.println(now.getDayOfWeek()); 			// MONDAY
		System.out.println(now.getHour() + "시");
		System.out.println(now.getMinute() + "분");
		System.out.println(now.getSecond() + "초");

		System.out.println("===========================날짜 조작===========================");
		System.out.println("==========plusDays, minusDays, withDays==========");
		// 날짜 조작
		LocalDateTime plusDays = now.plusDays(1).plusMonths(2).plusYears(1);		// 현재 날짜에 더하기
		System.out.println("plusDays : " + plusDays);
		
		LocalDateTime minusDays = now.minusYears(1).minusMonths(1).minusDays(1);	// 현재 날짜에서 빼기
		System.out.println("muinusDays : " + minusDays);
		
		LocalDateTime withDays = now.withYear(2025).withMonth(3).withDayOfMonth(10);	// 그냥 내가 지정한 것과 같다
		System.out.println("withDays : " + withDays);
		
//		now.isAfter/isBefore(해당 날짜) => 오늘이 해당 날짜보다 이전/이후인가 => return 타입 boolean
		System.out.println("isAfter : " + now.isAfter(withDays));		// now가 withDays보다 이후인가
		System.out.println("isBefore : " + now.isBefore(withDays));		// now가 withDays보다 이전인가
		
		System.out.println("==========LocalDate==========");
		// LocalDate : 날짜 정보를 저장
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate : " + localDate);
		localDate = LocalDate.of(2024, 12, 25);
		System.out.println(localDate);
		
		System.out.println("==========LocalTime==========");
		// LocalTime : 시간 정보만을 저장
		LocalTime localTime = LocalTime.now();
		System.out.println("localTime : " + localTime);
		localTime = LocalTime.of(17, 49, 59);
		System.out.println(localTime);
	}
	
	
	/*	Period와 Duration (시간 계산)
	 	- 날짜와 시간 간격을 표현하기 위한 클래스
	 	- Period : 두 날짜 간의 차이
	 	- Duration : 시간의 차이
	 */
	
	public void method2() {
		 System.out.println("==========LocalDate => Period ==========");
		 LocalDate date1 = LocalDate.of(2024, 1, 1);
		 LocalDate date2 = LocalDate.of(2025, 12, 31);

		 // between 메서드 : 두 날짜의 차이 (until 메서드와 별반 차이는 X)
		 Period pe = Period.between(date1, date2);
		 System.out.println("pe : " + pe);					// P1Y11M30D : 연도/월/일
		 
		 System.out.println("years : " + pe.getYears());
		 System.out.println("years : " + pe.get(ChronoUnit.YEARS));
		 
		 System.out.println("months : " + pe.getMonths());
		 System.out.println("months : " + pe.get(ChronoUnit.MONTHS));
		 
		 System.out.println("days : " + pe.getDays());
		 System.out.println("days : " + pe.get(ChronoUnit.DAYS));
		 
		 System.out.println("==========LocalTime => Duration ==========");
		 LocalTime time1 = LocalTime.of(0, 0, 0);
		 LocalTime time2 = LocalTime.of(11, 23, 55);
		 
		Duration du = Duration.between(time1, time2);
		System.out.println("du : " + du);
		
		System.out.println("hour : " + du.toHours());
		System.out.println("minutes : " + du.toMinutes());
		System.out.println("seconds : " + du.toSeconds());
		
		// 문자열을 LocalDate 객체로 파싱 (parse)
		System.out.println("=======문자열 =(parsing)=> LocalDate=======");
		LocalDate date = LocalDate.parse("2024-02-08");
		System.out.println(date);
		
		// DateTimeFormatter : 날짜와 시간을 포맷팅(Formatting)된 문자열을 변환하는 메서드를 제공하는 클래스
		System.out.println("============DateTimeFormatter============");
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss");
		String formatDate = today.format(ofPattern);
		System.out.println(formatDate);
	}
	
	public void method3() {	// sol
		// ChronoUnit.DAYS.between(날짜, 날짜)
		// 날짜.until(날짜, ChronoUnit.DAYS)
		System.out.println("============D-Day 계산기============");
		
		// 오늘 날짜
		LocalDate today = LocalDate.now();
		
		System.out.print("년 : ");
		int Y = sc.nextInt();
		System.out.print("월 : ");
		int M = sc.nextInt();
		System.out.print("일 : ");
		int D = sc.nextInt();
		
		LocalDate inputDate = LocalDate.of(Y, M, D);
		
		long dDay = ChronoUnit.DAYS.between(today, inputDate);
//		dDay = today.until(inputDate, ChronoUnit.DAYS);
//		System.out.println(dDay);
		
		if(dDay < 0) {
			System.out.println("D + " + (-dDay));
		} else if (dDay > 0) {
			System.out.println("D - " + dDay);
		} else {
			System.out.println("D - DAY");
		}
		
	}
	
	public void method3_my() {
		System.out.println("============D-Day 계산기============");
		LocalDate today = LocalDate.now();
		
		System.out.print("YEAR : ");
		int year = sc.nextInt();
		System.out.print("MONTH : ");
		int month = sc.nextInt();
		System.out.print("DAY : ");
		int day = sc.nextInt();
		
		LocalDate date = LocalDate.of(year, month, day);
		
		if(today.isAfter(date)) {
			System.out.println("D + " + (date.until(today, ChronoUnit.DAYS) +1));
		} else if (today.isBefore(date)){
			System.out.println("D - " + today.until(date, ChronoUnit.DAYS));
		} else {
			System.out.println("D-Day");
		}

	}

}
