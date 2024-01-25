package K_Collection;

import java.util.ArrayList;
import java.util.Collections;

public class Practice1_ArrayList {

	public static void main(String[] args) {

		ArrayList<Integer> lotto = new ArrayList<Integer>();
//		lotto.add(2);
//		lotto.add(1);
//		lotto.add(0);
//		
//		ArrayList<Integer> lotto2 = new ArrayList<Integer>();
//		lotto2.add(2);
//		lotto2.add(1);
//		lotto2.add(0);
//		
//		Collections.sort(lotto);
//		Collections.sort(lotto2);
		
		
		while (lotto.size() < 6) {
			
			int num = (int) (Math.random() * 45 + 1);
			if(!lotto.contains(num)) {
				lotto.add(num);
			}
		}

		int count = 0;

		while (true) {
			ArrayList<Integer> myLotto = new ArrayList<Integer>();
			System.out.println("로또 번호 : " + lotto);
			while (myLotto.size() < 6) {
				int num = (int) (Math.random() * 45 + 1);
				if(!myLotto.contains(num)) {
					myLotto.add(num);
				}
			}
			count++;
			System.out.println("내 번호 : " + myLotto);

			Collections.sort(lotto);
			Collections.sort(myLotto);
			
			if (myLotto.equals(lotto)) {
				System.out.println("횟수 : " + count);
				break;
			}
		}

	}

}
