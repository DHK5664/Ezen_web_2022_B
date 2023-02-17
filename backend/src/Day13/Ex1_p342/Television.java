package Day13.Ex1_p342;

//책 340p 기준 객체B

public class Television implements RemoteControl{
	// 클래스명 implements 인터페이스명 : 구현하다
		// 인터페이스 안에 추상된 메소드를 해당 클래스가 구현하겠다는 뜻
		// 필수작업 : !!추상메소드 구현 (상속은 안해도 대는데 얘는 해야댐)
	
	// 1. 인터페이스 추상메소드를 구현
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
	
}
