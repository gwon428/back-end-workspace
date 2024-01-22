package com.kh.polymorphism;

import java.util.Scanner;

import com.kh.polymorphism.controller.EmployeeController;
import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.child.Manager;
import com.kh.polymorphism.model.child.Secretary;
import com.kh.polymorphism.model.parent.Employee;

/*	다형성 (Polymorphism)
 	- 하나의 객체변수가 여러 가지 모양과 모습을 가지는 능력
 	- 부모 타입으로 자식 객체를 생성하는 것
 	- 
 */

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		Employee e1 = new Employee("이수근", 12000);
		Engineer eg1 = new Engineer("김영철", 56000, "JAVA", 200);
		Manager m1 = new Manager("강호동", 23000, "기획팀");
		Secretary s1 = new Secretary("서장훈", 34000, "강호동");
		
		System.out.println(e1);
		System.out.println(eg1);
		System.out.println(m1);
		System.out.println(s1);
		
		System.out.println();
		
		// 다형성 방식으로 객체 생성 (부모 타입(Employee)으로 객체 생성)
//		Engineer eg2 = new Engineer("김영철", 56000, "JAVA", 200);
		Employee eg2 = new Engineer("김영철", 56000, "JAVA", 200);	
		
//		Manager m2 = new Manager("강호동", 23000, "기획팀");
		Employee m2 = new Manager("강호동", 23000, "기획팀");
		
//		Secretary s2 = new Secretary("서장훈", 34000, "강호동");
		Employee s2 = new Secretary("서장훈", 34000, "강호동");
		
		
		System.out.println(eg2);
		System.out.println(m2);
		System.out.println(s2);

		System.out.println();
		
		// 다형성 + 객체 배열 
		Employee[] empArr = {e1, eg2, m2, s2};
		
		for (Employee employee : empArr) {
			System.out.println(employee);
		}
		
		System.out.println();
		
		
		
		// 이름으로 사람 찾기

		EmployeeController ec = new EmployeeController();
		
		System.out.print("찾는 사람 이름 : ");
		String name = sc.nextLine();
		
		Employee result = ec.findEmployeeByName(name, empArr);
		// 매개변수로 배열도 담을 수 있음..
		
		if (result != null) {
			System.out.println(result);
		} else {
			System.out.println("찾는 사람이 없습니다.");
		}
		
		// 찾은 사람의 연봉은?
		// 엔지니어의 경우 보너스가 있기 때문에 보너스를 찾아야 함..
		System.out.println(result.getName() + "님의 연봉 : " + ec.getAnnualSalary(result));
		
		// 전체 사람들의 연봉 총합은?
		System.out.println("전체 사람들의 연봉 총합 : " + ec.getTotalSalary(empArr));
		
	}

}
