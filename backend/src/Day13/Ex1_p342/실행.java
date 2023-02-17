package Day13.Ex1_p342;

//책 340p 기준 객체A

public class 실행 {
	public static void main(String[] args) {
		// 1. 인터페이스를 사용하는 구현객체
			// 1. 인터페이스는 타입 이므로 변수처럼 사용 가능
			// 2. 참조하지 않고 있는 변수는 null 대입	(타입으로 사용 가능)
		RemoteControl control1 = null;
			// 3. 해당 인터페이스를 implements 선언한 객체의 주소는 대입 가능 
		RemoteControl control2 = new Television();
			// 4. 해당 인터페이스를 implements 선언 하지 않는 객체의 주소는 대입 안됨
		//RemoteControl control3 = new Audio();
		
		// 2. 
		RemoteControl rc; // 1. 인터페이스 변수 선언 [스택영역 선언]
		rc = new Television();
			// 위와 같지만 아래꺼는 단발성(스택영역에 저장이 안되어있기 때문에 한번 사용하면 업서짐)
			RemoteControl rc2 = new Television();
			
				// new Television(); [ 힙 영역에 객체 선언하고 주소를 반환 ]
				// 반환된 주소를 'rc' 스택 영역에 변수 대입
		// 3. 구현객체를 이용한 메소드 실행
		rc.turnOn();
			// 위와 같지만 밑은 스택영역이 없어서 다음에는 사용 불가
			new Television().turnOn();
		
		// 4. 리모콘 교체 // 형변환 자유롭다.
		rc = new Audio();
		rc.turnOn();
	}
}







