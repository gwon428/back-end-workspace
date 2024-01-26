package E_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayPractice_ArrayList {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		ArrayPractice_ArrayList a = new ArrayPractice_ArrayList();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
		a.method5();
	}
	/*
	 * 길이가 5인 배열을 선언하고 과일 5개로 초기화 한 후 본인이 좋아하는 과일 하나를 출력하세요. (과일 5개는 뭐든지~)
	 * 
	 * */
	public void method1() {
		
//		ArrayList<String> fruitList = new ArrayList<String>();
		
//		fruitList.add("복숭아");
//		fruitList.add("멜론");
//		fruitList.add("사과");
//		fruitList.add("바나나");
//		fruitList.add("체리");
		
//		int num = (int)(Math.random()*5);
//		System.out.println(fruitList.get(num));
		
		// 배열 => ArrayList 변환 (Arrays.aslist(배열명));
		String[] fruit = {"복숭아", "멜론", "사과", "바나나", "체리"};
		ArrayList<String> fruitList = new ArrayList<String>(Arrays.asList(fruit));
		
		System.out.println(fruitList);
		int num = (int)(Math.random()*5);
		System.out.println(fruitList.get(num));
	}
	
	/*
	 * 사용자에게 배열의 길이와 배열의 크기 만큼 사용자한테 입력 받은 값으로 초기화 한 후
	 * 각 입력 받은 값이 잘 들어갔는지 출력 후 저장된 값들의 합을 출력하세요.
	 * 
	 * 정수 : 5
	 * 배열 0번째 인덱스에 넣을 값 : 4
	 * 배열 1번째 인덱스에 넣을 값 : -4
	 * 배열 2번째 인덱스에 넣을 값 : 3
	 * 배열 3번째 인덱스에 넣을 값 : -3
	 * 배열 4번째 인덱스에 넣을 값 : 2
	 * [4, -4, 3, -3, 2]
	 * 2
	 * */
	public void method2() {
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		int sum = 0;
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		for(int i=0; i<num; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			
			int answer = sc.nextInt();
			arrList.add(answer);
			sum += answer;
			
//			arrList.add(sc.nextInt());
//			sum += arrList.get(i);
		}
		
		System.out.println(arrList);
		System.out.println(sum);
		
	}
	
	
	/*
	 * 음식 메뉴는 자유롭게! 개수도 자유롭게! 배열 사용해서
	 * 사용자가 입력한 값이 배열에 있으면 "배달 가능", 없으면 "배달 불가능"을 출력하세요.
	 * 
	 * */
	public void method3() {
		String[] menu = {"떡볶이", "마라탕", "케이크", "닭발", "피자", "치킨"};
		ArrayList<String> menuList = new ArrayList<String>(Arrays.asList(menu));
		
		System.out.print("주문하실 메뉴를 골라주세요 : ");
		String select = sc.nextLine();
		
		boolean check = false;
		for(String food : menuList) {
			if(select.equals(food)) {
				check = true;
			}
		}
		System.out.println(check ? "배달 가능" : "배달 불가능");
	}
	
	/*
	 * 
	 * 사용자에게 주민등록번호를 입력받아 성별자리 이후부터 *로 가리고 출력하세요.
	 * 단, 원본 배열은 건드리지 않고! 
	 * 
	 * 주민등록번호 : 123456-1234567
	 * 123456-1******
	 * 
	 * */
	public void method4() {
		System.out.print("주민등록번호 : ");
		String no = sc.nextLine();
		
		char[] charNo = no.toCharArray();

		
		String[] strNo = no.split("");
		ArrayList<String> noList = new ArrayList<String>(Arrays.asList(strNo));
		for(int i=0; i<noList.size(); i++) {
			if(i <= 7) {
				System.out.print(noList.get(i));
			} else {
				System.out.print('*');
			}
		}
	}
	
	/*
	 * 사용자가 입력한 단어를 거꾸로 뒤집어서 출력하세요. 
	 * 
	 * 단어 입력 : programming
	 * gnimmargorp
	 * 
	 * */
	public void method5() {
		System.out.print("단어 입력 : ");
		String word = sc.nextLine();
		String[] wordArr = word.split("");
//		for (int i = wordArr.length - 1; i >= 0; i--) {
//			System.out.print(wordArr[i]);
//		}
		ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(wordArr));
		Collections.reverse(wordList);
		for(String s : wordList) {
			System.out.print(s);
		}
	}
	
}
