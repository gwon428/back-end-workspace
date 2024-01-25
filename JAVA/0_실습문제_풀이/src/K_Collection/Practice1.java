package K_Collection;

import java.util.TreeSet;

public class Practice1 {

	public static void main(String[] args) {
		// 당첨될 로또 번호를 담을 공간 생성
		TreeSet<Integer> lotto = new TreeSet<Integer>();
	
		
		// 조건식이 i<6이 아닌 이유는, 중복일 때 입력이 안되기 때문에 사이즈가 6이 아닌 정렬이 나오기도 하기 때문에
		while (lotto.size() < 6) {
			int num = (int) (Math.random() * 45 + 1);
			lotto.add(num);
		}

		int count = 0;
		
		
		while (true) {
			TreeSet<Integer> myLotto = new TreeSet<Integer>();
			System.out.println("로또 번호 : " + lotto);
			while (myLotto.size() < 6) {
				int num = (int) (Math.random() * 45 + 1);
				myLotto.add(num);
			}
			count ++;
			System.out.println("내 번호 : " + myLotto);
			
			// 멈추는 조건 : 로또 번호와 내 번호가 정확히 일치하는 경우
			if (myLotto.equals(lotto)) {
				System.out.println("횟수 : " + count);
				break;
			} 
		}
		
	}

}
