package chap01;

import java.util.Scanner;

public class JudgeABC2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

	     System.out.print("정수를 입력하세요.: ");
	     int num = sc.nextInt();
	     
	     if (num == 1) {
	    	 System.out.println("A");
	     } else if (num == 2) {
	    	 System.out.println("B");
	     } else if (num == 3) {
	    	 System.out.println("C");
	     }
	}

}
