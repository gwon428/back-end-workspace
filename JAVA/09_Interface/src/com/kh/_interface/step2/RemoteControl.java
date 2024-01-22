package com.kh._interface.step2;

// 인터페이스들은 여러 개 상속 가능 -> 인터페이스에서는 구현을 하지 않았기 때문에 중복되어도 ㄱㅊ -> 중복 허용
// (클래스는 다중 상속 불가!!)
public interface RemoteControl extends Searchable, Volume {
	void turnOn();
	void turnOff();
}
