package com.kh.list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class B_Other {

	public static void main(String[] args) {
		B_Other b = new B_Other();
		
//		b.method1();	// Vector
//		b.method2();
		b.method3();
	}
	
	/*	1. Vector
	 	- 동기화(Synchronized) 메서드로 구성 (동기화를 제공한다!) (개념을 스레드를 알아야함!) => 뒤에 설명 추가
	 */
	public void method1() {
		Vector v = new Vector();
		
		v.add(0);
		v.add(1);
		System.out.println(v);
		System.out.println("size(크기) : " + v.size());			// 2
		System.out.println("capacity(용량) : " + v.capacity());	// 10
		
		for (int i=1; i<10; i++) {
			v.add(i);
		}
		System.out.println("size(크기) : " + v.size());			// 11
		System.out.println("capacity(용량) : " + v.capacity());	// 20
		
		// capacity를 size에 맞춤
		v.trimToSize();
		System.out.println("size(크기) : " + v.size());			// 11
		System.out.println("capacity(용량) : " + v.capacity());	// 11
	}
	
	/*	2. Stack (스택) : 마지막에 저장한 것을 제일 먼저 꺼내는 LIFO(Last In First Out) 구조 */
	public void method2() {
		
		Stack s = new Stack();
		
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s);
		s.pop();
		System.out.println(s);
		s.push(4);
		s.pop();
		s.push(5);
		s.push(6);
		s.push(7);
		s.pop();
		System.out.println(s);
		
	}

	/* 3. Queue (큐)	: 처음에 저장한 것을 제일 먼저 꺼내는 FIFO(First In First Out) 구조 */
	public void method3() {
		
		// 큐는 인터페이스!
		
		Queue q = new LinkedList();
		
		q.offer(0);
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.poll();
		q.add(4);
		q.remove();
		q.add(5);
		q.add(6);
		q.add(7);
		q.remove();
		
		System.out.println(q);
		
	}
}
