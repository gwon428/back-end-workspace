package F_Object.practice3.controller;

import F_Object.practice3.model.Employee;

public class EmployeeController {
private Employee employee = new Employee();
	
	// add => 오버로딩!! 메서드 이름이 같고 매개변수의 개수가 다른
	public void add(int empNo, String name, char gender, String phone) {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
	}
	
	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setBonus(bonus);
	}

	public void modify(String phone) {
		employee.setPhone(phone);
	}

	public void modify(int salary) {
		employee.setSalary(salary);
	}
	
	public void modify(double bonus) {
		employee.setBonus(bonus);
	}
	
	public Employee info() {
		return employee;
	}
}
