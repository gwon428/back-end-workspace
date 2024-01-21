package D_Control;

import java.util.Scanner;

class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		LoopPractice l = new LoopPractice();
		
//		l.method1();
//		l.method2();
//		l.method3();
//		l.method4();
//		l.method5();
		l.method6();
	}
    /*
        1. 사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.print("사용자 입력 : ");
    	int num = Integer.parseInt(sc.nextLine());
		for (int i = num; i >= 1; i--) {
			System.out.println(i);
		}
    }

    // 2. 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
	public void method2() {
		int sum = 0;
		int j = 0;

		while (true) {
			for (int i = 1; sum <= 100; i++) {
				if (i % 2 == 0) {
					j = 0;
					j = i * (-1);
					sum += j;
				} else {
					sum += i;
				}
				if (sum > 100) {
					System.out.println(i);
					break;
				}
			}
		}
	}

    /*
        3. 사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	System.out.print("문자열 : ");
    	String str = sc.nextLine();
    	
    	System.out.print("문자 : ");
    	char ch = sc.nextLine().charAt(0);
    	
    	int count = 0;
    	for (int i=0; i<str.length(); i++) {
    		if(ch == str.charAt(i)) {
    			count += 1;
    		}
    	}
    	System.out.println(str + " 안에 포함된 " + ch + " 개수 : " + count);
    }

    /*
        4. 0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	while(true) {
    		double random = Math.random() * 10;
    		random = (int) random;
    		System.out.println((int) random);
    		if(random == 0) break;
    	}
    }

    /*
        5. 주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
    	int i1 = 0;
    	int i2 = 0;
    	int i3 = 0;
    	int i4 = 0;
    	int i5 = 0;
    	int i6 = 0;
    	
    	for(int i = 0; i < 10; i++) {
    		double random = Math.random() * 6 +1;
			switch ((int) random) {
			case 1:
				i1 += 1;
				break;
			case 2:
				i2 += 1;
				break;
			case 3:
				i3 += 1;
				break;
			case 4:
				i4 += 1;
				break;
			case 5:
				i5 += 1;
				break;
			case 6:
				i6 += 1;
				break;
			}
    	}
    	System.out.println("1 : " + i1);
    	System.out.println("2 : " + i2);
    	System.out.println("3 : " + i3);
    	System.out.println("4 : " + i4);
    	System.out.println("5 : " + i5);
    	System.out.println("6 : " + i6);
    }

    /*
        6. 사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.


        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
    */
    public void method6() {
    	System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	
		while (true) {

			String rsp = "";
			String result = "";
			int mi = 0;
			System.out.print("가위바위보 : ");
			String me = sc.nextLine();

			if (me.equals("가위")) {
				mi = 1;
			} else if (me.equals("바위")) {
				mi = 2;
			} else if (me.equals("보")) {
				mi = 3;
			}

			double random = Math.random() * 3 + 1;
			int rand = (int) random;

			if (rand == 1) {
				rsp = "가위";
			} else if (rand == 2) {
				rsp = "바위";
			} else if (rand == 3) {
				rsp = "보";
			}

			System.out.println("컴퓨터 : " + rsp);
			System.out.println(name + " : " + me);

			if (rand == mi) {
				result = "비겼습니다.";
				System.out.println(result);
			} else if (rand == 1 && mi == 3 || rand == 2 && mi == 1 || rand == 3 && mi == 2) {
				result = "졌습니다ㅠㅠ";
				System.out.println(result);
			} else if (rand == 1 && mi == 2 || rand == 2 && mi == 3 || rand == 3 && mi == 1) {
				result = "이겼습니다 !";
				System.out.println(result);
				break;
			}
		}

    }

}