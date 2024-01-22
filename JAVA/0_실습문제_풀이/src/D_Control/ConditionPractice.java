package D_Control;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConditionPractice {
	Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
		ConditionPractice c = new ConditionPractice();
		
//		c.practice1();
//		c.practice2();
//		c.practice3();
//		c.practice4();
//		c.practice5();
//		c.practice6();
//		c.practice7();
//		c.practice8();
//		c.practice9();
//		c.practice10();
		c.practice11();
	}

    /*
       1. 키보드로 정수를 입력 받은 정수가 양수이면서 짝수일 때만 “짝수다”를 출력하고 짝수가 아니면 “홀수다“를 출력하세요.
       양수가 아니면 “양수만 입력해주세요.”를 출력하세요.
    
       숫자를 한 개 입력하세요 : -8
       양수만 입력해주세요.
     */
    public void practice1() {
    	System.out.print("숫자를 한 개 입력하세요 : ");
    	int num = sc.nextInt();
    
    	if(num <= 0) {	// 양수가 아닌 것들부터 처리!
    		System.out.println("양수만 입력해주세요.");
    	} else if (num % 2 == 0) {
    		System.out.println("짝수다");
    	} else {
    		System.out.println("홀수다");
    	}
    
    	/*
    	if(num > 0) {
    		if (num % 2 == 0) System.out.println("짝수다");
    		else System.out.println("홀수다");
    	} else System.out.println("양수만 입력해주세요.");
    	*/
    }

    /*
        2. 정수 num1과 num2를 입력 받아서 두 수가 같으면 1 다르면 -1을 출력하세요.

        num1 : 2
        num2 : 3
        -1

        num1 : 11
        num2 : 11
        1
     */
    public void practice2() {
    	System.out.print("num1 : ");
    	int num1 = sc.nextInt();
    	System.out.print("num2 : ");
    	int num2 = sc.nextInt();
    	
		if (num1 == num2) {
			System.out.println(1);
		} else {
			System.out.println(-1);
		}
    	
    	
    }

    /*
        3. A 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라준다.
        피자 조각 수와 피자를 먹는 사람의 수를 입력받아 한 사람 당 최소 한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지 출력하세요.

        피자 조각 수 : 7
        피자 먹는 사람 수 : 10
        2

     */
    public void practice3() {
        System.out.print("피자 조각 수 : ");
        int pizza = sc.nextInt();
        
        System.out.print("피자 먹는 사람 수 : ");
        int person = sc.nextInt();
        
        int result = person / pizza;
        
        if (person % pizza != 0) {
        	result++;
        }
        
        System.out.println(result);
    }

    /*
        4. 국어, 영어, 수학 세 과목의 점수를 키보드로 입력 받고 합계와 평균을 계산하고 합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현하세요.
        (합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우)
        합격 했을 경우 과목 별 점수와 합계, 평균, “축하합니다, 합격입니다!”를 출력하고 불합격인 경우에는 “불합격입니다.”를 출력하세요.
    
        국어점수 : 88 
        수학점수 : 50 
        영어점수 : 40 
        불합격입니다.

        국어점수 : 88
        수학점수 : 50
        영어점수 : 45
        합계 : 183
        평균 : 61.0
        축하합니다, 합격입니다!
     */
    public void practice4() {
    	System.out.print("국어 점수 : ");
    	int kor = sc.nextInt();
    	
    	System.out.print("수학 점수 : ");
    	int math = sc.nextInt();
    	
    	System.out.print("영어 점수 : ");
    	int eng = sc.nextInt();
    	
    	int sum = kor + math + eng;
    	double avg = (double) sum / 3;
    	
    	if (kor >= 40 && math >= 40 && eng >= 40 && avg >= 60) {
    		System.out.println("합계 : " + sum);
    		System.out.printf("평균 : %.2f\n", avg);
    		System.out.println("축하합니다, 합격입니다!");
    	} else {
    		System.out.println("불합격입니다.");
    	}
    }

    /*
        5. B 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만원 이상 사면 20%를 할인해준다.
        구매한 옷의 가격을 입력했을 때, 지불해야 할 금액을 출력하세요.
        
        구매한 옷 가격 : 580,000
        464,000
     */
    public void practice5() {
    	System.out.print("구매한 옷 가격 : ");
    	int price = sc.nextInt();
    	
    	if(price >= 500000) {
    		price = (int) (price * 0.8);
    	} else if (price >= 300000) {
    		price = (int) (price * 0.9);
    	} else if (price >= 100000) {
    		price = (int) (price * 0.95);
    	}
    	
		DecimalFormat pri = new DecimalFormat("###,###");
    	System.out.println("할인된 옷 가격 : " + pri.format(price));
    }


    /*
        6. 각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류한다.
        입력받은 각에 따라 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 출력하세요.
     */
    public void practice6() {
    	System.out.print("각도를 입력하세요 : ");
		int angle = Integer.parseInt(sc.nextLine());
		int result = 0;

		if (angle > 0 && angle < 90) {
			result = 1;
		} else if (angle == 90) {
			result = 2;
		} else if (angle < 180) {
			result = 3;
		} else if (angle == 180) {
			result = 4;
		}
		System.out.println(result);
    }


    /*
      7. 아이디, 비밀번호를 정해두고 로그인 기능을 작성하세요.
          로그인 성공 시 "로그인 성공", 
          아이디가 틀렸을 시 "아이디가 틀렸습니다.",
          비밀번호가 틀렸을 시 "비밀번호가 틀렸습니다.",
          아이디와 비밀번호 둘 다 틀렸을 시 "로그인 실패" 를 출력하세요.

          아이디 : happy
          비밀번호 : 1234
          로그인 성공!

          아이디 : happy
          비밀번호 : 23467
          비밀번호가 틀렸습니다.

          아이디 : happy222
          비밀번호 : 1234
          아이디가 틀렸습니다.
    */
    public void practice7() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		String idCheck = "happy";
		String pwdCheck = "1234";
		
		if(id.equals(idCheck) && pwd.equals(pwdCheck)) {
			System.out.println("로그인 성공!");
		} else if (!id.equals(idCheck)) {
			System.out.println("아이디가 틀렸습니다.");
		} else if (!pwd.equals(pwdCheck)) {
			System.out.println("비밀번호가 틀렸습니다."); 
		} else if (!id.equals(idCheck) && !pwd.equals(pwdCheck)) {
			System.out.println("로그인 실패");
		}
    }

    /*
        8. 키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라 저체중 / 정상체중 / 과체중 / 비만을 출력하세요.
            BMI = 몸무게 / (키(m) * 키(m))
            BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
            BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
            BMI가 30이상일 경우 고도 비만

            키(m)를 입력해 주세요 : 1.62
            몸무게(kg)를 입력해 주세요 : 46
            BMI 지수 : 17.527815881725342
            저체중

     */
    public void practice8() {
       System.out.print("키(m)를 입력해 주세요 : ");
       double height = sc.nextDouble();
       
       System.out.print("몸무게(kg)를 입력해 주세요 : ");
       double weight = sc.nextDouble();
       
       double bmi = weight / (height * height);
       System.out.println("BMI 지수 : " + bmi);
       
       
       String result = "저체중";
       
       if(bmi >= 30) {
    	   result = "고도 비만";
       } else if (bmi >= 25) {
    	   result = "비만";
       } else if (bmi >= 23) {
    	   result = "과체중";
       } else if (bmi >= 18.5) {
    	   result = "정상 체중";
       }       
       
       System.out.println(result);
       
    }

    /*
        9. 키보드로 두 개의 양수와 연산 기호를 입력 받아 연산 기호에 맞춰 연산 결과를 출력하세요.
            (단, 양수가 아닌 값을 입력하거나 제시되어 있지 않은 연산 기호를 입력 했을 시 “잘못 입력하셨습니다. 프로그램을 종료합니다.” 출력)

            숫자 입력 : 15
            숫자 입력 : 4
            연산자를 입력(+,-,*,/,%) : /
            15 / 4 = 3

     */
    public void practice9() {
    	System.out.print("숫자 입력 : ");
    	int num1 = Integer.parseInt(sc.nextLine());
    	
    	System.out.print("숫자 입력 : ");
    	int num2 = Integer.parseInt(sc.nextLine());
    	
    	if(num1 <= 0 || num2 <= 0) {
    		System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
    		return;	// return을 만나는 순간 메서드에서 나가는 것 !
    	}
    	
    	System.out.print("연산자를 입력(+, -, *, /, %) : ");
    	char ch = sc.nextLine().charAt(0);
    	
    	int result = 0;
    	
		switch (ch) {
		case '+': result = num1 + num2;
			break;
		case '-': result = num1 - num2;
			break;
		case '*': result = num1 * num2;
			break;
		case '/': result = num1 / num2;
			break;
		case '%': result = num1 % num2;
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			return;
		}
    	
		// 두 수가 양수이면서 연산 기호를 제대로 입력 받은 경우만 여기까지 옴!
		System.out.printf("%d %c %d = %d", num1, ch, num2, result);
    }

    /*
      10. 아래 예시와 같이 메뉴를 출력하고 메뉴 번호를 누르면 “OO메뉴입니다“를, 종료 번호를 누르면 “프로그램이 종료됩니다.”를 출력하세요

        1. 입력
        2. 수정
        3. 조회
        4. 삭제
        9. 종료
        메뉴 번호를 입력하세요 : 3
        조회 메뉴입니다.
     */
    public void practice10() {
    	System.out.println("1. 입력");
    	System.out.println("2. 수정");
    	System.out.println("3. 조회");
    	System.out.println("4. 삭제");
    	System.out.println("9. 종료");
    	System.out.print("메뉴 번호를 입력하세요 : ");
    	int menu = Integer.parseInt(sc.nextLine());
    	
    	String result = "없는 메뉴입니다.";
    	
    	switch(menu) {
    	case 1: result = "입력 메뉴입니다.";
    		break;
    	case 2: result = "수정 메뉴입니다.";
    		break;
    	case 3: result = "조회 메뉴입니다.";
    		break;
    	case 4: result = "삭제 메뉴입니다.";
    		break;
    	case 9: result = "프로그램이 종료됩니다.";
    		break;
    	}
		System.out.println(result);
    }

/*
        11. 중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
            총 점 100점 중 배점으로는 다음과 같다.
            중간고사 (20%), 기말고사 (30%), 과제 (30%), 출석 (20%)

            이 때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 입력

            총 점이 70점 이상이면서 전체 강의의 70%이상 출석을 했을 경우 Pass,
            아니면 Fail을 출력하세요.


            중간 고사 점수 : 80
            기말 고사 점수 : 90
            과제 점수 : 50
            출석 횟수 : 15
            ===========결과==========
            중간 고사 점수(20) : 16.0
            기말 고사 점수(30) : 27.0
            과제 점수 (30) : 15.0
            출석 점수 (20) : 15.0
            총점 : 73.0
            PASS

            중간 고사 점수 : 80
            기말 고사 점수 : 30
            과제 점수 : 60
            출석 횟수 : 18
            ===========결과==========
            FAIL [점수 미달] (총점 61.0)

            중간 고사 점수 : 90
            기말 고사 점수 : 100
            과제 점수 : 80
            출석 횟수 : 13
            ===========결과==========
            FAIL [출석 횟수 부족] (13/20)

            중간 고사 점수 : 100
            기말 고사 점수 : 80
            과제 점수 : 40
            출석 횟수 : 10
            ===========결과==========
            FAIL [출석 횟수 부족] (10/20)
            FAIL [점수 미달] (총점 66.0)

     */
    public void practice11() {
    	System.out.print("중간 고사 점수 : ");
		int mid = sc.nextInt();

		System.out.print("기말 고사 점수 : ");
		int fin = sc.nextInt();

		System.out.print("과제 점수 : ");
		int task = sc.nextInt();

		System.out.print("출석 회수 : ");
		int ab = sc.nextInt();
	
		System.out.println("=====결과=====");
    
		double mids = mid*0.2;
		double fins = fin * 0.3;
		double tasks = task * 0.3;

		double sum = mid*0.2 + fin * 0.3 + task * 0.3 + ab;
		
		if (sum >= 70 && ab >= 20 * 0.7) {
			System.out.println("중간 고사 점수(20) : " + mid);
			System.out.println("기말 고사 점수(30) : " + fin);
			System.out.println("과제 점수(30) : " + tasks);
			System.out.println("출석 점수(20) : " + ab);
			System.out.println("총점 : " + sum);
    		System.out.println("PASS");
		} else {
			if (ab < 20 * 0.7) {
				System.out.println("FAIL [출석 횟수 부족] (" + ab + "/20)");
			}
			if(sum < 70) {
				System.out.println("FAIL [점수 미달] (총점 : " + sum + ")");
			}
		}
		
    }
    
}