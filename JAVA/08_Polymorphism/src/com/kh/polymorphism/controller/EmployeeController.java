package com.kh.polymorphism.controller;

import java.util.Scanner;

import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.parent.Employee;

public class EmployeeController {
	Scanner sc = new Scanner(System.in);
	
	// 각각 매개변수와 리턴값을 처리하는 방법 !!
	
	
	// 이름으로 사람 찾기
	public Employee findEmployeeByName(String name, Employee[] empArr) {
		
		for(Employee employee : empArr) {
			if (employee.getName().equals(name)) {
				return employee;
			}
		} return null;	
	}
	
	// 찾은 사람의 연봉은? -> 한 사람의 연봉을 찾는 기능
	public int getAnnualSalary(Employee e) {
		// instanceof 연산자
		int annualSalary = e.getSalary()*12;
		if(e instanceof Engineer) {
			// 객체를 하나 더 생성 (강제 형 변환)
			Engineer engineer = (Engineer) e; 		// 부모 -> 자식 : 강제 형 변환 
			return annualSalary + engineer.getBonus();
		} else {
			return annualSalary;
		}
	}
	
	// 전체 사람들의 연봉 총합은?
	public int getTotalSalary(Employee[] empArr) {
		int sum = 0;
		for(Employee employee : empArr) {
			sum += getAnnualSalary(employee);
		}
		return sum;
	}
}
