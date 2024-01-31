package com.kh.step3;

import java.awt.Toolkit;

public class BeepPrintTest2 {

	public static void main(String[] args) {

		BeepThread beep = new BeepThread();
		beep.start();

		Toolkit tool = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			// 경고음 5번 울리는 작업
			tool.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
