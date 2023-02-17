package Day13.Ex1_p342;

//책 340p 기준 인터페이스

// class 키워드 : 클래스 선언 키워드
	// extends : 상속 [ 연장하다 .]
// interface 키워드 : 인터페이스 선언 키워드
	// implement : 구현하다.
public interface RemoteControl { // in s

	// 인터페이스 멤버
		// 1. 상수 필드	[변수 X ]
		// 2. 생성자 X 	[ new 사용 불가능 -> 스스로 객체 못만듦;]
		// 3. 메소드
			// ! 추상[abstract]메소드
			// 디폴트 메소드
			// 정적 메소드
	// * 추상메소드 : 선언부만 존재 / 구현부{ } 작성 안함 / 즉 선언만 한다
	public void turnOn();
	
}// in e


