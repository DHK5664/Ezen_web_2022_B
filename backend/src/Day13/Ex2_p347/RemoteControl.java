package Day13.Ex2_p347;

public interface RemoteControl {

	// *상수 필드 [ 인터페이스는 변수 X ]
		// 상수밖에 안되는 이유 : new연산자를 못씀(생성자 X ) -> 객체 X -> 인스턴스멤버X -> static멤버만 가능
		// 상수 : static final	// 고정된 값 -> 초기값 필수 : 변수 선언시 값 대입
		// 인터페이스 에서는 생략
	public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;		// 자동으로 public static final이 붙음 
	
	// *추상메소드 !제일 중요!
		// 리턴타입 , 메소드명 , 매개변수 만 선언
		// { } 선언 X
		// public abstract 생략 가능 --> 보이진 않지만 자동생성
		// 해당 클래스들이 implements 했을때 -> 오버라이딩 필수
	//1.
	public abstract void turnOn();	// { } 없당!
	void turnOff();	// public abstract 
	void setVolume(int volume);
	
	// *디폴트 메소드
		// 클래스에서 사용하는 메소드 동일	[ 선언과 구현 ]
		// 선언부 앞에 default 선언
		// 해당 클래스들이 implements 했을때 -> 오버라이딩 선택
	// 2.
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다. ");
			setVolume(MIN_VOLUME);
		}else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	// *정적 메소드
		// 구현객체가 필요없다... implements 없이 가능
		// static 선언
		// implements 없이 사용하는 메소드 
	// 3. 
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교환합니다. ");
	}
}
