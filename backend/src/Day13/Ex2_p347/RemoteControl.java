package Day13.Ex2_p347;

public interface RemoteControl {

	// 상수 필드 [ 인터페이스는 변수 X ]
		// 상수밖에 안되는 이유 : new연산자를 못씀(생성자 X ) -> 객체 X -> 인스턴스멤버X -> static멤버만 가능
		// 상수 : static final	// 고정된 값 -> 초기값 필수 : 변수 선언시 값 대입
		// 인터페이스 에서는 생략
	public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;		// 자동으로 public static final이 붙음 
	
	// 추상메소드
		// 리턴타입 , 메소드명 , 매개변수 만 선언
		// { } 선언 X
		// public abstract 생략 가능 --> 보이진 않지만 자동생성
	//1.
	public abstract void turnOn();	// { } 없당!
	void turnOff();	// public abstract 
	void setVolume(int volume);
}
