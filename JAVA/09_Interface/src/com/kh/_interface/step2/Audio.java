package com.kh._interface.step2;

import java.util.spi.TimeZoneNameProvider;

// 클래스와 클래스 간, 인터페이스와 인터페이스 간 => extends
// 클래스와 인터페이스 간 => implements
public class Audio implements RemoteControl {

	private int volume;
	
	@Override	//Searchable
	public void search(String url) {
		System.out.println(url + "을 연결합니다.");
	}

	@Override	// Volume
	public void setVolume(int volume) {
		// 상수에 접근할 땐 그 인터페이스명으로 접근 가능
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨 : " + this.volume);
	}

	@Override	// Searchable/RemoteControl
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}

	@Override	// Searchable/RemoteControl
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}
	
}