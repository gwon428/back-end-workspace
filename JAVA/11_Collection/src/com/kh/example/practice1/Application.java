package com.kh.example.practice1;

import java.util.HashSet;
import java.util.Set;

public class Application {

	public static void main(String[] args) {
//		List lotto = new ArrayList();
//
//		for (int i = 1; i <= 45; i++) {
//			lotto.add(i);
//		}
//		System.out.println(lotto);

		Set<Integer> my = new HashSet<Integer>();
		Set<Integer> ans = new HashSet<Integer>();
		
//		my.add(1);
//		ans.add(1);
		
//		System.out.println(my);
//		System.out.println(ans);
//		System.out.println(my == ans);
//		System.out.println(my.equals(ans));
		

		boolean check = false;
		int count = 0;
		for (int i = 0; ans.size() < 6; i++) {
			ans.add((int) (Math.random() * 45 + 1));
		}
		while(!check) {
			count ++;
			System.out.println("로또 번호 : " + ans);
			for(int i=0; my.size()<6; i++) {
				my.add((int) (Math.random() * 45 + 1));
			}
			System.out.println("내 번호 : " + my);
			if(my.equals(ans)) {
				check = true;
			} else {
				my.clear();
			}
			
		}
		System.out.println("횟수 : " + count);

	}

}
