package com.kh.test3;

public class Overloading {

// 1) 매개변수가 없는 메서드의 경우, 같은 메서드명을 가진 다른 메서드를 가지고 올 수 없다.
	public void test() {}

// 2) 같은 메서드명을 가진 메서드의 경우, 매개변수의 형태가 같을 때 오류가 난다.
	public void test(String str) {}

	
	public void test(int i) {}

// 2) 같은 메서드명을 가진 메서드의 경우, 매개변수의 형태가 같을 때 오류가 난다.
	public void test(String s) {}

	public void test(char ch) {}

	
	public void test(String str, int i) {}

	public void test(int i, String str) {}

	
	private void test(int i) {}

	public int test() {return 0;}

}
