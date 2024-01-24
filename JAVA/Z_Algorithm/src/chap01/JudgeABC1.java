package chap01;

//입력한 정숫값을 판단(1)
import java.util.Scanner;

class JudgeABC1 {
	
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     System.out.print("정수를 입력하세요.: ");
     int num = sc.nextInt();

     if (num == 1)
         System.out.println("Ａ");
     else if (num == 2)
         System.out.println("Ｂ");
     else
         System.out.println("Ｃ");
 }
}